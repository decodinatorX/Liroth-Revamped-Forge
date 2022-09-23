package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.core.entities.FreakshowEntity;
import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.decodinator.liroth.core.entities.LirothianMimicEntity;
import com.decodinator.liroth.core.entities.PierPeepEntity;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import com.decodinator.liroth.core.entities.ShadeEntity;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import com.decodinator.liroth.core.entities.VileSharkEntity;
import com.decodinator.liroth.core.entities.WarpEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Liroth.MOD_ID, bus = Bus.MOD)
public class LirothForgeCommonEventsHandler {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LirothEntities.FORSAKEN_CORPSE.get(), ForsakenCorpseEntity.createForsakenCorpseAttributes().build());
		event.put(LirothEntities.FREAKSHOW.get(), FreakshowEntity.createFreakshowAttributes().build());
		event.put(LirothEntities.FUNGAL_FIEND.get(), FungalFiendEntity.createFungalFiendAttributes().build());
		event.put(LirothEntities.LIROTHIAN_MIMIC.get(), LirothianMimicEntity.createLirothianMimicAttributes().build());
		event.put(LirothEntities.PIER_PEEP.get(), PierPeepEntity.createPierPeepAttributes().build());
		event.put(LirothEntities.PROWLER.get(), ProwlerEntity.createProwlerAttributes().build());
		event.put(LirothEntities.SHADE.get(), ShadeEntity.createShadeAttributes().build());
		event.put(LirothEntities.SKELETAL_FREAK.get(), SkeletalFreakEntity.createSkeletalFreakAttributes().build());
		event.put(LirothEntities.SOUL_ARACHNID.get(), SoulArachnidEntity.createSoulArachnidAttributes().build());
		event.put(LirothEntities.VILE_SHARK.get(), VileSharkEntity.createVileSharkAttributes().build());
		event.put(LirothEntities.WARP.get(), WarpEntity.createWarpAttributes().build());
	}
}
