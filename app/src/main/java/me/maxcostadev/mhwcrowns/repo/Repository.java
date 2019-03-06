package me.maxcostadev.mhwcrowns.repo;

import java.util.List;

import me.maxcostadev.mhwcrowns.model.Monster;

public interface Repository {
    public List<Monster> getMonsters();
    public void setMonsters();
}
