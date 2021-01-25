package com.extended.api.interact;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.SceneObject;
import com.epicbot.api.shared.entity.*;
import com.epicbot.api.shared.methods.IMouseAPI;
import com.epicbot.api.shared.methods.ITabsAPI;
import com.epicbot.api.shared.util.Random;
import com.epicbot.api.shared.util.time.Time;

/*
*
* @author Kittyrgnarok/Buy the Dip
*
 */

public class ExtInteract {
    private static final APIContext ctx = APIContext.get();
    private static final WidgetChild viewPort = ctx.widgets().get(165,8);

    public static boolean playerInteract(Player p, String s) {

        if (!p.isVisible()) {
            ctx.camera().turnTo(p);
            p.hover();
            return false;
        }
        p.interact(s);
        Time.sleep(50);
        if (ctx.menu().isOpen()) {
            p.interact(s);
        }
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean playerInteract(String name, String interact){
        final Player a = ctx.players().query().notMe().named(name).results().first();

        if (!a.isVisible()){
            ctx.camera().turnTo(a);
            a.hover();
            return false;
        }
        a.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            a.interact(interact);

        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));

    }
    public static boolean objectInteract(String sceneObject, String interact){
        SceneObject obj = ctx.objects().query().nameContains(sceneObject).actions(interact).results().nearest();
        if (!obj.isVisible()){
            ctx.camera().turnTo(obj);
            obj.hover();
            return false;
        }
        obj.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            obj.interact(interact);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean objectInteract(SceneObject sceneObject, String interact){
        if (!sceneObject.isVisible()){
            ctx.camera().turnTo(sceneObject);
            sceneObject.hover();
            return false;
        }
        sceneObject.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            sceneObject.interact(interact);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean objectInteract(String sceneObject){
        SceneObject obj = ctx.objects().query().nameContains(sceneObject).results().nearest();
        if (!obj.isVisible()){
            ctx.camera().turnTo(obj);
            obj.hover();
            return false;
        }
        obj.click();
        Time.sleep(50);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean objectInteract(SceneObject sceneObject){
        if (!sceneObject.isVisible()){
            ctx.camera().turnTo(sceneObject);
            sceneObject.hover();
            return false;
        }
        sceneObject.click();
        Time.sleep(50);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean npcInteract(String npcName, String interact){
        NPC npc = ctx.npcs().query().nameContains(npcName).actions(interact).reachable().results().nearest();
        if (!npc.isVisible()){
            ctx.camera().turnTo(npc);
            return false;
        }
        npc.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            npc.interact(interact);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean npcInteract(String npcName){
        NPC npc = ctx.npcs().query().nameContains(npcName).reachable().results().nearest();
        if (!npc.isVisible()){
            ctx.camera().turnTo(npc);
            npc.hover();
            return false;
        }
        npc.click();
        Time.sleep(50);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean npcInteract(NPC npc){
        if (!npc.isVisible()){
            ctx.camera().turnTo(npc);
            npc.hover();
            return false;
        }
        npc.click();
        Time.sleep(50);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean npcInteract(NPC npc, String interact){
        if (!npc.isVisible()){
            ctx.camera().turnTo(npc);
            npc.hover();
            return false;
        }
        npc.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            npc.interact(interact);
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean pickupItem(GroundItem item){
        if (!item.isVisible()){
            ctx.camera().turnTo(item);
            item.hover();
        }
        item.interact("Take");
        Time.sleep(50);
        if (ctx.menu().isOpen())
            item.interact("Take");
        return Time.sleep(Random.nextInt(10,250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean invInteract(String itemName, String interact){
        if (!ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY)){
            ctx.tabs().open(ITabsAPI.Tabs.INVENTORY);
            return false;
        }
        ItemWidget item = ctx.inventory().getItem(itemName);
        return item.interact(interact);
    }
    public static boolean invInteract(String itemName){
        if (!ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY)){
            ctx.tabs().open(ITabsAPI.Tabs.INVENTORY);
            return false;
        }
        ItemWidget item = ctx.inventory().getItem(itemName);
        return item.interact();
    }
    public static boolean useItem(String name){
        return invInteract(name);
    }

    public static boolean turnTo(LocatableEntity entity) {
        if (entity.isVisible()) return true;
        ctx.camera().turnTo(entity, true);
        Time.sleep(Random.nextInt(150, Random.nextInt(75, 1000)));
        return entity.isVisible();
    }

    public static void eatFood(String name) {
        if (!ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY)){
            Time.sleep(Random.nextInt(35,350));
            ctx.tabs().open(ITabsAPI.Tabs.INVENTORY);
            Time.sleep(Random.nextInt(75,850), () ->ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY));
            return;
        }

        int health = ctx.localPlayer().getHealthPercent();
        ctx.inventory().getItem(name).interact("Eat");
        Time.sleep(Random.nextInt(25,800), () -> ctx.localPlayer().getHealthPercent() > health);
    }

    public static void toggleRun(boolean bool){
        ctx.walking().setRun(bool);
        if (bool)
            Time.sleep(Random.nextInt(35, 350), () -> ctx.walking().isRunEnabled());
        else
            Time.sleep(Random.nextInt(35,350), () -> !ctx.walking().isRunEnabled());
    }


    public static int equipItem(String name) {
        System.out.println("Equip item");
        if (ctx.inventory().getItem(name).interact())
            Time.sleep(3000, () -> ctx.equipment().contains(name));
        return 50;
    }
}
