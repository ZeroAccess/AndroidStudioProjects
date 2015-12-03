package com.delta.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by learnovate on 2/25/14.
 */
public class AdoptData {
    public static List<Dog> mDogList = new ArrayList<Dog>(){
        {
            add(new Dog("Weston",
                    "Weston was a big rockstar in the 90's, but has since settled down and lived a quite life of digging holes and chewing shoes.",
                    "david",
                    "+1-202-555-0114"));
            add(new Dog("Gizmo",
                    "So adorable that this dog won the 2014 award for \"Most Likely To Break Your Heart And Pee A Little While Doing It\"",
                    "gizmo",
                    "+1-202-555-0189"));
            add(new Dog("Gizmo",
                    "This dog basically is an artist at heart, he knows how to paint with his tail, but often just craps on the floor",
                    "gizmo",
                    "+1-202-555-0187"));
            add(new Dog("MogWai",
                    "Quite a trickster, MogWai has been known to steal socks and T-shirts, wash them, then hide them in your freezer.",
                    "mogwai",
                    "+1-202-555-0190"));
            add(new Dog("Pepper",
                    "She is a little skeptical of cats, Rubik's cubes, and people using cameras",
                    "pepper",
                    "+1-202-555-0109"));
            add(new Dog("Shadow",
                    "This dog is incredible at cuddling up in a blanket.  So good that he has been mistaken for a burrito numerous times.",
                    "shadow",
                    "+1-202-555-0141"));
            add(new Dog("Vegas",
                    "Not much is know about this dog, except that he stole a pizza in 1997",
                    "vegas",
                    "+1-202-555-0141"));
        }
    };

    public static List<Cat> mCatList = new ArrayList<Cat>(){
        {
            add(new Cat("Barry & Levon","Barry and Levon are quite a pair, they love pudding!","barrylevon",20));
            add(new Cat("Flash Gordon","We think this cat is sleeping, but its also possible he's stuck. ","flashgordon",12));
            add(new Cat("Kif","This cat is very nice and very judgemental. (note: box not included)","kif",8));
            add(new Cat("Mochi","This cat needs a very special diet of only the finest minced tuna and caviar.","mochi",11));
            add(new Cat("Kitty","A great mouser, she has a habit of bringing you presents year-round","kitty",10));
            add(new Cat("Mufassa","Not recommended for tame owners. Not housetrained. Don't tell him I said that.","mufassa",2));
        }
    };
}
