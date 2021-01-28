package com.company;

public class Estadisticas implements Comparable<Estadisticas> {
    private String hometeam;
    private String visitorteam;
    private String matchdate;
    private int goals_home;
    private int visitor_home;
    private int wins_home;
    private int loses_home;
    private int wins_visitant;
    private int loses_visitant;

    public Estadisticas(String hometeam, String visitorteam, String matchdate, int goals_home, int visitor_home, int wins_home, int loses_home, int wins_visitant, int loses_visitant) {
        this.hometeam = hometeam;
        this.visitorteam = visitorteam;
        this.matchdate = matchdate;
        this.goals_home = goals_home;
        this.visitor_home = visitor_home;
        this.wins_home = wins_home;
        this.loses_home = loses_home;
        this.wins_visitant = wins_visitant;
        this.loses_visitant = loses_visitant;
    }

    public String getHometeam() {
        return hometeam;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
    }

    public String getVisitorteam() {
        return visitorteam;
    }

    public void setVisitorteam(String visitorteam) {
        this.visitorteam = visitorteam;
    }

    public String getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(String matchdate) {
        this.matchdate = matchdate;
    }

    public int getGoals_home() {
        return goals_home;
    }

    public void setGoals_home(int goals_home) {
        this.goals_home = goals_home;
    }

    public int getVisitor_home() {
        return visitor_home;
    }

    public void setVisitor_home(int visitor_home) {
        this.visitor_home = visitor_home;
    }

    public int getWins_home() {
        return wins_home;
    }

    public void setWins_home(int wins_home) {
        this.wins_home = wins_home;
    }

    public int getLoses_home() {
        return loses_home;
    }

    public void setLoses_home(int loses_home) {
        this.loses_home = loses_home;
    }

    public int getWins_visitant() {
        return wins_visitant;
    }

    public void setWins_visitant(int wins_visitant) {
        this.wins_visitant = wins_visitant;
    }

    public int getLoses_visitant() {
        return loses_visitant;
    }

    public void setLoses_visitant(int loses_visitant) {
        this.loses_visitant = loses_visitant;
    }

    @Override
    public String toString() {
        return "\nEquipo Local = '" + hometeam + '\'' + " \nEquipo Visitante = '" + visitorteam + '\'' + " \nFecha del Partido = '" +
                matchdate + '\'' + " \nGoles Local = " + goals_home + " \nGoles Visitante = " + visitor_home + " \nVictorias Equipo Local = " +
                wins_home + " \nDerrotas Equipo Local = " + loses_home + " \nVictorias Equipo Visitante = " +
                wins_visitant + " \nDerrotas Equipo Visitante = " + loses_visitant +"\n ----------------";
    }

    @Override
    public int compareTo(Estadisticas o) {
        if(getLoses_home() < o.getLoses_home()) return -1;
        else if(getLoses_home() > o.getLoses_home()) return 1;
        else return 0;
    }


}
