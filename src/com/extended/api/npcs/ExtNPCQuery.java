package com.extended.api.npcs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;

public class ExtNPCQuery {

    public NPC getNearestNPC(String name, APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).results().nearest();
    }
    public NPC getNearestNPC(String name, String action, APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).actions(action).results().nearest();
    }
    public NPC getNotInCombatNPC(String name, APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).notInCombat().animation(-1).results().nearest();
    }
    public NPC getNotInCombatNPC(String name, String action ,APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).actions(action).notInCombat().animation(-1).results().nearest();
    }
}
