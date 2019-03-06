package me.maxcostadev.mhwcrowns.repo;

import java.util.List;

import me.maxcostadev.mhwcrowns.model.Monster;

public class RepositoryImpl implements Repository{


    public List<Monster> getMonsters(){
        if(isApiAvailable()){

        }
//        return getFileData();
        return null;
    }

    private Boolean isApiAvailable(){
        //TODO api implementation
        return false;
    }

    private Boolean isConnected(){
        //TODO connection test implementation
        return false;
    }

    public void setMonsters(){
        //TODO monster saving implementation
    }

}
