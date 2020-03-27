package de.oette.springhibernate.practice.one.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue
    public int id;

    public int getId() {
        return id;
    }
}
