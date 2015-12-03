package com.randstad.deltaobjects;

import java.util.ArrayList;

/**
 * Created by robertsg on 12/11/2014.
 */
public class JokeBot extends Bot{

    public static ArrayList<Joke> jokesIKnow = null;

    public JokeBot(ArrayList<Joke> jokesIKnow) {
        this.jokesIKnow = jokesIKnow;
    }

    public void tellJoke(){

        Double randomNumDouble = new Double(Math.random() * jokesIKnow.size());
        int randomNum = randomNumDouble.intValue();

        Joke myJoke = jokesIKnow.get(randomNum);

        sayJoke(myJoke);
    }

    protected void sayJoke(Joke aJoke){
        talk(aJoke.getJokeSetup());
        talk(aJoke.getJokePunchline());
    }
}
