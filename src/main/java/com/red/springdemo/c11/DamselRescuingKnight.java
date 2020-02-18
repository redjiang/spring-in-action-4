package com.red.springdemo.c11;

public class DamselRescuingKnight implements Knight {
    private RescuingDemselQuest quest;
    public DamselRescuingKnight(){
        this.quest = new RescuingDemselQuest();
    }

    public void embarkOnQuest(){
        quest.embark();
    }
}
