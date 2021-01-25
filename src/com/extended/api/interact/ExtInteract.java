package com.extended.api.interact;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.*;
import com.epicbot.api.shared.entity.details.Interactable;
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

    public static boolean interactableInteract(Interactable target)
    {
        target.click();
        Time.sleep(50);

        return Time.sleep(Random.nextInt(10, 250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }

    public static boolean interactableInteract(Interactable target,String interact)
    {
        target.interact(interact);
        Time.sleep(50);
        if (ctx.menu().isOpen())
            target.interact(interact);

        if (target.interactMatch("Use") && !ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY))
        {
            ctx.tabs().open(ITabsAPI.Tabs.INVENTORY);
            return false;
        }
        return Time.sleep(Random.nextInt(10, 250), () -> ctx.mouse().getMouseCrossColor().equals(IMouseAPI.CrossColor.RED));
    }
    public static boolean interactableInteract(String name)
    {
        Interactable target = null;

        if (ctx.npcs().query().nameContains(name).results().nearest() != null)
            target = ctx.npcs().query().nameContains(name).results().nearest();
        else if (ctx.objects().query().nameContains(name).results().nearest() != null)
            target = ctx.objects().query().nameContains(name).results().nearest();
        else if (ctx.players().query().notMe().named(name).results().nearest() != null)
            target = ctx.players().query().notMe().named(name).results().nearest();
        else if (ctx.inventory().getItem(name) != null)
            target = ctx.inventory().getItem(name);

        return target != null && interactableInteract(target);
    }

    public static boolean interactableInteract(String name, String interact)
    {
        Interactable target = null;

        if (ctx.npcs().query().nameContains(name).actions(interact).results().nearest() != null)
            target = ctx.npcs().query().nameContains(name).actions(interact).results().nearest();
        else if (ctx.objects().query().nameContains(name).actions(interact).results().nearest() != null)
            target = ctx.objects().query().nameContains(name).actions(interact).results().nearest();
        else if (ctx.players().query().notMe().named(name).results().nearest() != null)
            target = ctx.players().query().notMe().named(name).results().nearest();
        else if (ctx.inventory().getItem(name) != null)
            target = ctx.inventory().getItem(name);

        return target != null && interactableInteract(target,interact);
    }

    public static boolean pickupItem(GroundItem item)
    {
        return interactableInteract(item, "Take");
    }

    public static boolean pickupItem(String name)
    {
        GroundItem item = null;
        if (ctx.groundItems().query().named(name).results().nearest() != null)
            item = ctx.groundItems().query().named(name).results().nearest();

        return item != null && interactableInteract(item, "Take");
    }

    public static void eatFood(String name)
    {
        if (!ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY))
        {
            Time.sleep(Random.nextInt(35, 350));
            ctx.tabs().open(ITabsAPI.Tabs.INVENTORY);
            Time.sleep(Random.nextInt(75, 850), () -> ctx.tabs().isOpen(ITabsAPI.Tabs.INVENTORY));
            return;
        }

        int health = ctx.localPlayer().getHealthPercent();
        ctx.inventory().getItem(name).interact("Eat");
        Time.sleep(Random.nextInt(25, 800), () -> ctx.localPlayer().getHealthPercent() > health);
    }

    public static void toggleRun(boolean bool)
    {
        ctx.walking().setRun(bool);
        if (bool)
            Time.sleep(Random.nextInt(35, 350), () -> ctx.walking().isRunEnabled());
        else
            Time.sleep(Random.nextInt(35, 350), () -> !ctx.walking().isRunEnabled());
    }
}
