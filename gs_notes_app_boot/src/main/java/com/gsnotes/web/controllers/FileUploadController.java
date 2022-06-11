package com.gsnotes.web.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.gsnotes.bo.Etudiant;
import com.gsnotes.services.IElementInscriptionService;
import com.gsnotes.services.IElementService;
import com.gsnotes.services.IEtudiantService;
import com.gsnotes.services.IExcelDataService;
import com.gsnotes.services.IModuleInscriptionService;
import com.gsnotes.services.IModuleService;
import com.gsnotes.services.NavBarNoteService;
import com.gsnotes.services.ReadFileService;
import com.gsnotes.utils.export.ExcelHandlerException;

@Controller
@RequestMapping("/admin") 
public class FileUploadController {

	@Autowired
	ReadFileService fileService;
	
    @Autowired 
    IExcelDataService data;
    
    @Autowired 
    IEtudiantService studentService;
    
    @Autowired 
    NavBarNoteService list;
    
    @Autowired 
    IElementInscriptionService element;
    
    @Autowired
    IModuleInscriptionService mod;
    @Autowired 
    IModuleService mser;
    @Autowired 
    IElementService eser;
    
    List<String> msg=new ArrayList<String>();
    MultipartFile file;
    int state=0;
    @PostMapping("/uploadFile")
    public RedirectView uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException, ExcelHandlerException,InterruptedException
      {
  
    	 if (file.isEmpty())
    	      {
             msg.add(" Error: Please select a file to upload");
             state=1;
              }
    	 
    	else if (file.getOriginalFilename().endsWith(".xlsx") || file.getOriginalFilename().endsWith(".xls")) 
    	  {
             fileService.uploadFile(file);
             List<ArrayList<Object>> li = data.getExcelDataAsList(file.getOriginalFilename(),0);
             msg.add("Fichier uploaded' "+ file.getOriginalFilename()+"' !  ");
             Object[] header1={"ID","CNE","NOM","PRENOM","Element 1","Element 2","Moyenne","Validation"};
             int st = 0;
            
//           Verification du Header
             
             for(int i=0;i<header1.length;i++) 
               {
            	if(!li.get(2).get(i).equals(header1[i]))
           		   {
            	  	st=1;
        	   	    break; 
        		   }
               }
    
//              Verification des Elements
              for(int k=4;k<li.get(2).size()-2;k++) {
                 String s=String.valueOf(li.get(2).get(k));
              if(!mser.findBytitre(li.get(0).get(1).toString()).getElements().contains(eser.getBynom(s))) {
            	  msg.add("Error: Le module n'est pas correcte ");
            	  state=1;
            	  break;
              } 
              
           }
             
//             Verification de nombre de cases
             if(li.get(0).size()==6 && li.get(1).size()==6 && (li.get(2).size()==8 || li.get(2).size()==7)) 
               {
                if(li.get(0).get(0).equals("Module") && li.get(0).get(2).equals("Semestre") &&
                		li.get(1).get(0).equals("Enseignant") && li.get(1).get(2).equals("Session") && 
                		li.get(1).get(4).equals("Classe") && st==0) 
                     {
        	                msg.add("Stucture correcte");
        	                
        	                     
        	           if(list.getByalias(li.get(1).get(5).toString())) {
        	        	   msg.add("Error :niveau existe dans la BD");
        	        	   }
        	           else {
        	        	   msg.add("Erroe :Verifier le Niveau");
        	               state=1;
        	           }
        	           for(int i=3;i<li.size()-1;i++)
        	            {
        	        	 
//             	         Verifier les notes
        	        
        	        	   if(Double.valueOf(li.get(i).get(4).toString())>20 || Double.valueOf(li.get(i).get(5).toString())>20 || Double.valueOf(li.get(i).get(6).toString())>20 || Double.valueOf(li.get(i).get(4).toString())<0
        	        			   || Double.valueOf(li.get(i).get(5).toString())<0 || Double.valueOf(li.get(i).get(6).toString())<0) 
        	        	
        	        	   { msg.add("Error: Notes ne sont pas comprises entre 0 et 20");
        	        	   state=1;
        	        	   }    
                           else {
                        	   msg.add("Notes comprises entre 0 et 20");
                           }
        	        	   double somme=0;
                    	   for(int k=4;k<li.get(i).size()-2;k++)
                    		   somme+=Double.valueOf(li.get(i).get(k).toString())*Double.valueOf(eser.getBynom(li.get(2).get(k).toString()).getCurrentCoefficient());
    	        	        if(Double.valueOf(li.get(i).get(6).toString())!=(somme/(li.get(i).size()-5))) {
    	        	        	msg.add("Moyenne correcte");
    	        	        }    
    	        	        else {
    	        	        	msg.add("Error :Moyenne Incorrecte");
    	        	            state=1;
    	        	        }
//        	        	   Verifier les etudiant
        	        	   int valid=1;
        	        	   for(Etudiant e:studentService.getEtudiant()) {
//        	        		     (li.get(i).get(0)).equals(e.getIdUtilisateur())
        	        		   if(li.get(i).get(1).equals(e.getCne()) && ((String) li.get(i).get(3)).equals(e.getPrenom()) && li.get(i).get(2).equals(e.getNom()))
        	        		   {
        	        			   valid=0;
        	        			   break;
        	        	     }
        	        		   }
        	        	   if(valid==0) msg.add("Etudiant good");
        	        	   if(valid==1) {
        	        	     msg.add("Error: dans les etudiants");
        	        	     state=1;  
        	        	   }
//        	        	   Verifier la colonne validation
   
        	        	   if(!li.get(i).get(7).equals("V") && !li.get(i).get(7).equals("R") && !li.get(i).get(7).equals("VAR") && !li.get(i).get(7).equals("NV")) {
        	        		   msg.add("Validation n'est pas correcte");
        	        		   state=1;
        	        	       break;
        	        	   }
        	        	   else {
        	        		   msg.add("All Good");
        	        	   }
        	        	 
        	            }
                }
            } 
             
              else { 
            	  msg.add("Error: les Cases ne sont pas correctes");
            	  state=1;
                   }       	
              }
                 
    	  
            else   {msg.add("Error: il'ya des cases vides");
                 state=1;
            }
                
    	
         redirectAttributes.addFlashAttribute("Msg",msg);
    	   return new RedirectView("redirect:");
    	
      }   
	
    

    @GetMapping("/delete")
    public String removeFile() throws IOException {
    	if(file!=null) {
    	  data.removeFile(file.getOriginalFilename());	
    	  System.out.println("deleted");
    	}
    	return "admin/adminHome";
    }
    
  
    @GetMapping("/saveData")
   public String saveExcelData(Model model,Model model1) throws FileNotFoundException, IOException, ExcelHandlerException {
    	model1.addAttribute("message",msg);
    	if(state==0) {
    	data.saveExcelData(data.getExcelDataAsList(file.getOriginalFilename(),0));
    	return "admin/success";
    	}
    	else 
         return "admin/failed";
    }
}

	


	

