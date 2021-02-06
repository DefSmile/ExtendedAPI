package com.extended.api.NPC;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.query.NPCQueryBuilder;

public class ExtNPCQuery {
    
    public static NPC getNearestNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name).results().nearest(); }

    public static NPC getNearestNPC(String name, String action, APIContext ctx) { return ctx.npcs().query().nameMatches(name).actions(action).results().nearest(); }

    public static NPC getNotInCombatNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name).notInCombat().animation(-1).results().nearest(); }

    public static NPC getNotInCombatNPC(String name, String action ,APIContext ctx) { return ctx.npcs().query().nameMatches(name).actions(action).notInCombat().animation(-1).results().nearest(); }

    public static NPCQueryBuilder getNPC(String name, APIContext ctx) { return ctx.npcs().query().nameMatches(name); }

    public static NPC getNearestNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id).results().nearest(); }

    public static NPC getNearestNPC(int id, String action, APIContext ctx) { return ctx.npcs().query().id(id).actions(action).results().nearest(); }

    public static NPC getNotInCombatNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id).notInCombat().animation(-1).results().nearest(); }

    public static NPC getNotInCombatNPC(int id, String action ,APIContext ctx) { return ctx.npcs().query().id(id).actions(action).notInCombat().animation(-1).results().nearest(); }

    public static NPCQueryBuilder getNPC(int id, APIContext ctx) { return ctx.npcs().query().id(id); }
}
