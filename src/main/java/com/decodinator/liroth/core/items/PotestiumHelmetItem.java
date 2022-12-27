package com.decodinator.liroth.core.items;

import com.decodinator.liroth.Liroth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class PotestiumHelmetItem extends ArmorItem implements IAnimatable  {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    
    public PotestiumHelmetItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Properties builder)  {
        super(materialIn, slot, builder.tab(Liroth.liroth_combat_tab));
    }

	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("loop", EDefaultLoopTypes.LOOP));
	    return PlayState.CONTINUE;
	}

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<PotestiumHelmetItem>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
