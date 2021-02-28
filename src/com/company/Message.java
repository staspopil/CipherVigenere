package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class Message {

    String message="";
    String key="";
    String newmessage="";
    Boolean isEncrypte = true;
    ArrayList<Character> Alphabet = new ArrayList<Character>();
    String tempmessage = " ";

    public Message(){
        initAlphabet();
        System.out.println(Alphabet);
    }

    public void setData(String m, String k,Boolean n){
        this.key = k;
        this.message = m;
        this.isEncrypte = n;
        updateKey();
        message = message.toLowerCase(Locale.ROOT);
        key = key.toLowerCase(Locale.ROOT);
        message = message.replaceAll(" ","");
        key = key.replaceAll(" ", "");
        tempmessage = message;
    }

    public String getNewMessage(){
        return newmessage;
    }


    public void initAlphabet(){
        Alphabet.clear();
        for (int i = 97; i<123; i++){
            Alphabet.add((char)i);
        }
    }

    public void updateKey(){
        if(key.length()<message.length()){
            while (key.length()<message.length()){
                key=key+key;
            }
        }

    System.out.println("key = "+key);
    }

    public void toEncrypt(){
        int c;
        for (int i = 0 ; i<message.length(); i++){
            if(!Alphabet.contains(message.charAt(i))){
                JOptionPane.showMessageDialog(null,"The message has unacceptable Symbols\n It Should be letters of Eng Alphabet");
                break;
            }
            if(!Alphabet.contains(key.charAt(i))){
                JOptionPane.showMessageDialog(null,"The key has unacceptable Symbols\n It Should be letters of Eng Alphabet");
                break;
            }
        c = Alphabet.indexOf(message.charAt(i))+Alphabet.indexOf(key.charAt(i));
         System.out.print(Alphabet.indexOf(message.charAt(i))+"+"+Alphabet.indexOf(key.charAt(i))+"="+c%26);
            System.out.println("  "+message.charAt(i)+"+"+key.charAt(i)+"="+Alphabet.get(c%26));

             newmessage = newmessage+Alphabet.get(c%26);
        }
        System.out.println("Message = \t\t    " + tempmessage);
        System.out.println("Key = \t\t        " + key);
        System.out.println("Processed Message = "+ newmessage);
    }

    public void toDecrypt(){
        int c;
        for(int i = 0; i<message.length(); i++){

            if(!Alphabet.contains(message.charAt(i))){
                JOptionPane.showMessageDialog(null,"The message has unacceptable Symbols\n It Should be letters of Eng Alphabet");
                break;
            }
            if(!Alphabet.contains(key.charAt(i))){
                JOptionPane.showMessageDialog(null,"The key has unacceptable Symbols\n It Should be letters of Eng Alphabet");
                break;
            }

            c = (Alphabet.indexOf(message.charAt(i))+26-Alphabet.indexOf(key.charAt(i)))%26;
            newmessage = newmessage+Alphabet.get(c);

        }

        System.out.println("Message = \t\t    " + tempmessage);
        System.out.println("Key = \t\t        " + key);
        System.out.println("Processed Message = "+ newmessage);
    }


    public void process(){
        newmessage = "";
        if(isEncrypte){
            toEncrypt();
        }
        else{
            toDecrypt();
        }
    }



}
