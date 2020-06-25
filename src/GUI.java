/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;  
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.misc.Resource;

/**
 *
 * @author mohamed
 */
public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         GridPane pane1 = new GridPane();  
            //First window
           //Creating an image 
        try {
            //URL url = Resource.class.getResource();
            FileInputStream inputstream = new FileInputStream("/Users/mohamed/Desktop/advanced prog/12th project/Hotel reservation/src/images/33221515.jpg"); 
            Image image = new Image(inputstream); 
            //Setting the image view
            ImageView imageView = new ImageView(image); 
            //Setting the position of the image 
            imageView.setX(50); 
            imageView.setY(40); 

            //setting the fit height and width of the image view 
            imageView.setFitHeight(400); 
            imageView.setFitWidth(500); 
            pane1.getChildren().add(imageView);
            //Setting the preserve ratio of the image view 
            imageView.setPreserveRatio(true); } 
            catch (FileNotFoundException ex) {
                       Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

            



            Button btn1 = new Button("Information");
            Button btn2 = new Button("Reservation");


            //setting gridpane and adding image to it
            pane1.setPadding(new Insets(10,10,10,10)) ;
            pane1.setVgap(20);
            pane1.setHgap(20);
            pane1.setAlignment(Pos.CENTER);
            
            //making HBOX to put in the btns then add it to the grid pane
            HBox btnshbox = new HBox();
            btnshbox.getChildren().addAll(btn1,btn2);
            btnshbox.setAlignment(Pos.CENTER);
            btnshbox.setSpacing(30);
            pane1.add(btnshbox, 0, 1);
    
     
      
     //Btn1 set to function (Hotel information)
                            btn1.setOnAction(new EventHandler<ActionEvent>() {
                           @Override public void handle(ActionEvent e) {
                                Stage hotelinfostage = new Stage();
                                Text text = new Text();
                                Button hinfo = new Button("Hotel Information");
                                Button cinfo = new Button("Client Info");
                                GridPane hotelinfogp = new GridPane();
                                 hotelinfogp.setPadding(new Insets(10,10,10,10)) ;
                                 hotelinfogp.setVgap(30);
                                 hotelinfogp.setHgap(30);
                                 hotelinfogp.setAlignment(Pos.CENTER);
                                 hotelinfogp.add(hinfo,0,2);
                                 hotelinfogp.add(cinfo,1,2);
                                 VBox infovb = new VBox();
                                 
                                 

                               
                                                         hinfo.setOnAction(new EventHandler<ActionEvent>() {
                                                                @Override public void handle(ActionEvent e) {
                                                                       infovb.getChildren().clear();
                                                                        hotelinfogp.getChildren().remove(infovb);
                                                                        hotel h = new hotel();
                                                                        text.setText(h.displayinfo());
                                                                        hotelinfogp.add(text, 0, 0);
                                                                        
                                                                        
                                                                       

                                                                }
                                                            });
                                                        cinfo.setOnAction(new EventHandler<ActionEvent>() {
                                                                @Override public void handle(ActionEvent e) {
                                                                    hotelinfogp.getChildren().remove(text);
                                                                    infovb.getChildren().clear();
                                                                    //Name text field
                                                                   
                                                                        Label name = new Label("Name ");
                                                                        TextField nametf = new TextField ();
                                                                        HBox namehb = new HBox();
                                                                        namehb.setAlignment(Pos.CENTER_LEFT);
                                                                        namehb.getChildren().addAll(name, nametf);
                                                                        namehb.setSpacing(10); 
                                                                        //ID text field
                                                                        Label id = new Label("Client ID ");
                                                                        TextField idtf = new TextField ();
                                                                        
                                                                        HBox idhb = new HBox();                                                                     
                                                                        idhb.getChildren().addAll(id, idtf);
                                                                        idhb.setSpacing(10); 
                                                                        //
                                                                        Button submit = new Button("Submit");
                                                                        infovb.setSpacing(10);
                                                                        infovb.setAlignment(Pos.CENTER_LEFT);
                                                                        
                                                                        infovb.getChildren().addAll(namehb ,idhb,submit);
                                                                        hotelinfogp.add(infovb,0,0);
                                                                        
                                                                        
                                                                       
                                                                     submit.setOnAction(new EventHandler<ActionEvent>() {
                                                                        @Override public void handle(ActionEvent e) {
                                                                       infovb.getChildren().clear();
                                                                        hotelinfogp.getChildren().remove(infovb);
                                                                        Client c = new Client(Integer.parseInt(idtf.getText()),nametf.getText());
                                                                        text.setText(c.getClientrecords());
                                                                         hotelinfogp.add(text, 0, 0,1,1);
                                                                        }


                                                                        
                                                                    });
                                                                        
                                                                        
                                                                        
                                                                     
                                                                }
                                                            });
                                                         
                                                         
                                
                                Scene hotelinfoscene = new Scene(hotelinfogp , 800 , 400);
                                hotelinfostage.setScene(hotelinfoscene);
                                        
                                hotelinfostage.setTitle("Hotel Infromation");
                                hotelinfostage.show();
                               

                           }
                       });
                            //Set btn2 on action(Reserve)
                            btn2.setOnAction(new EventHandler<ActionEvent>() {
                           @Override public void handle(ActionEvent e) {
                               Checkdate check = new Checkdate();
                               check.Checkreservation();
                               Stage Reserve = new Stage();
                               Text text = new Text();
                               Reserve.setTitle("Reservation Menu");
                               Button showEmptyRoomsbtn = new Button("Show Empty Rooms");
                               Button Reservebtn = new Button("Reserve");
                                GridPane resgp = new GridPane();
                                 resgp.setPadding(new Insets(10,10,10,10)) ;
                                 resgp.setVgap(20);
                                 resgp.setHgap(30);
                                 resgp.setAlignment(Pos.TOP_LEFT);
                                 resgp.add(showEmptyRoomsbtn,0,0);
                                 resgp.add(Reservebtn,1,0);
                                    
                                    ComboBox comboBox = new ComboBox();
                                    Button submit = new Button("submit");
                                    comboBox.getItems().addAll(
                                                  "Single Rooms",
                                                  "Double Rooms"
                                                                                );
                                    VBox textfeildsvb = new VBox();
                               Scene resscene = new Scene(resgp,800,300);
                               
                                                    showEmptyRoomsbtn.setOnAction(new EventHandler<ActionEvent>() {
                                                                @Override public void handle(ActionEvent e) {
                                                                    textfeildsvb.getChildren().clear();
                                                                    resgp.add(comboBox, 0, 1);
                                                                    resgp.add(submit, 0, 2);
                                                                    
                                                                     submit.setOnAction(new EventHandler<ActionEvent>() {
                                                                        @Override public void handle(ActionEvent e) {
                                                                            if(text.toString()!= null){text.setText("");}
                                                                            resgp.getChildren().remove(text);
                                                                            textfeildsvb.getChildren().clear();
                                                                        if(comboBox.getValue() == "Single Rooms"){
                                                                        singleRoom room = new singleRoom();
                                                                       text.setText(room.displayallroomsinfo(false));
                                                                         }else if(comboBox.getValue() == "Double Rooms"){
                                                                        doubleRoom room = new doubleRoom();
                                                                        text.setText(room.displayallroomsinfo(false));
                                                                    }
                                                                         else{text.setText("No option selected");}
                                                                         resgp.add(text,2,1,2,3);


                                                                        }
                                                                    }); }
                                                            });
                                                                     Reservebtn.setOnAction(new EventHandler<ActionEvent>() {
                                                                            @Override public void handle(ActionEvent e) {
                                                                                
                                                                        if(textfeildsvb.getChildren()!=null){  textfeildsvb.getChildren().clear();}
                                                                          resgp.getChildren().removeAll(comboBox,submit,text);
                                                                        Button submit2 = new Button("Submit");
                                                                        Button print = new Button("Print");
                                                                        Label name = new Label("Name ");
                                                                        TextField nametf = new TextField ();
                                                                        HBox namehb = new HBox();
                                                                        namehb.setAlignment(Pos.CENTER_LEFT);
                                                                        namehb.getChildren().addAll(name, nametf);
                                                                        namehb.setSpacing(30); 
                                                                        //ID text field
                                                                        Label id = new Label("Client ID ");
                                                                        TextField idtf = new TextField ();
                                                                        HBox idhb = new HBox();                                                                     
                                                                        idhb.getChildren().addAll(id, idtf);
                                                                        idhb.setSpacing(30); 
                                                                        //No of days textfield
                                                                        Label days = new Label("Days ");
                                                                        TextField daystf = new TextField ();
                                                                        daystf.cancelEdit();
                                                                        namehb.getChildren().addAll(days,daystf);
                                                                        //Room number textfield
                                                                        Label Roomno = new Label("Room Number ");
                                                                        TextField rmtf = new TextField ();
                                                                        idhb.getChildren().addAll(Roomno,rmtf);
                                                                        //checkindate textfield
                                                                        Label checkindate = new Label("Checkin Date ");
                                                                        TextField cidtf = new TextField ("DD / MM / YEAR");
                                                                        
                                                                        HBox dhb = new HBox();
                                                                        dhb.setSpacing(40);
                                                                        dhb.setAlignment(Pos.CENTER_LEFT);
                                                                        
                                                                        dhb.setSpacing(10);
                                                                        Label checkoutdate = new Label("Checkout Date ");
                                                                        TextField codtf = new TextField ("DD / MM / YEAR");
                                                                        dhb.getChildren().addAll(checkindate, cidtf,checkoutdate,codtf);
                                                                        textfeildsvb.getChildren().addAll(namehb , idhb , dhb,submit2);
                                                                        textfeildsvb.setSpacing(10);
                                                                        
                                                                        
                                                                        submit2.setOnAction(new EventHandler<ActionEvent>() {
                                                                                @Override public void handle(ActionEvent e) { 
                                                                                   boolean checkin = check.checkin(cidtf.getText()) 
                                                                                           , checkout = check.checkout(codtf.getText());
                                                                                  long days = check.getDateDiff(codtf.getText(), cidtf.getText(), TimeUnit.DAYS);
                                                                                   
                                                                                 if(      check.equality(cidtf.getText(), codtf.getText())
                                                                                         || checkin == false || checkout == false 
                                                                                         || rmtf.getText().equals("")   || rmtf.getText().equals("Missing")
                                                                                         || cidtf.getText().equals("")  ||  cidtf.getText().equals("Missing")
                                                                                         || codtf.getText().equals("")  ||  codtf.getText().equals("Missing")
                                                                                         || idtf.getText().equals("")   ||  idtf.getText().equals("Missing")
                                                                                         || nametf.getText().equals("") ||  nametf.getText().equals("Missing") 
                                                                                        
                                                                                      
                                                                                         ){
                                                                                      
                                                                                      if(check.equality(cidtf.getText(), codtf.getText())){
                                                                                          daystf.setText("Invalid reservation");
                                                                                      }
                                                                                      if(checkout == false){
                                                                                          codtf.setText("Invalid date");
                                                                                      }
                                                                                      if(checkin == false){
                                                                                          cidtf.setText("Invalid date");
                                                                                      }
                                                                                      List<TextField> lst =  new ArrayList<>() ;
                                                                                      lst.add(rmtf);
                                                                                      lst.add(cidtf);
                                                                                      lst.add(codtf);
                                                                                      lst.add(idtf);
                                                                                      lst.add(nametf);
                                                                                    
                                                                                      for(int i = 0 ; i < lst.size(); i++){
                                                                                      
                                                                                         if(lst.get(i).getText().equals("") || lst.get(i).getText().equals("Missing")){
                                                                                              lst.get(i).setText("Missing");
                                                                                              
                                                                                          }
                                                                                      }
                                                                       
                                                                                     }else{
                                                                                      daystf.setText(""+days);
                                                                                      textfeildsvb.getChildren().add(print);
                                                                                      Reservation res = new Reservation(Integer.parseInt(rmtf.getText())
                                                                                              ,cidtf.getText(),codtf.getText(),Integer.parseInt(idtf.getText())
                                                                                              ,nametf.getText(),Integer.parseInt(daystf.getText()));
                                                                                  
                                                                                 }
                                                                                
                                                                                
                                                                                
                                                                                }
                                                                            });
                                                                        print.setOnAction(new EventHandler<ActionEvent>() {
                                                                        @Override public void handle(ActionEvent e) {
                                                                            SendToprinter print = new SendToprinter();
                                                                            print.print( "  Client name: "+ nametf.getText() +" \n " 
                                                                                    + "  Client ID: "+Integer.parseInt(idtf.getText()) + "\n"
                                                                                    + "   Reservation information "+ "Room Number: "+ Integer.parseInt(rmtf.getText()) + "\n"
                                                                                    + "   Checkin Date: "+cidtf.getText() + "\n"
                                                                                    + "  Checkout Date: "+ codtf.getText() + "\n"
                                                                                    + "   Days: "+Integer.parseInt(daystf.getText()) + "\n"  
                                                                                    + "                                             Client Signature: ......................" );



                                                                        }
                                                                    });
                                                                        
                                                                        resgp.add(textfeildsvb,1,3,2,3);
                                                                            }
                                                                        });
                                                                    
                                                                    

                                                               
                                                     
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               Reserve.setScene(resscene);
                               Reserve.show();
                               
                               
                               

                           }
                       });
                          
     
      //Creating a scene object 
      Scene scene = new Scene(pane1, 550, 500);  
      

      //Adding scene to the stage 
      primaryStage.setScene(scene);
      primaryStage.setTitle("Hilton Hotel");
      
      //Displaying the contents of the stage 
      primaryStage.show();
    
    
    
    
          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
