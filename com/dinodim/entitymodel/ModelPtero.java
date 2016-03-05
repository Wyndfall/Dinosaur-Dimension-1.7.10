package com.dinodim.entitymodel;

import com.dinodim.main.DDUtils;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

//Date: 8/31/2015 6:57:07 PM
//Template version 1.1
//Java generated by Techne
//Keep in mind that you still need to fill in some blanks
//- ZeuX

public class ModelPtero extends ModelBase
{
	//fields
	ModelRenderer body;
	ModelRenderer legs;
	ModelRenderer arm1;
	ModelRenderer arm2;
	ModelRenderer wing1;
	ModelRenderer wing2;
	ModelRenderer neck;
	ModelRenderer head;
	ModelRenderer head2;
	ModelRenderer beak;

	public ModelPtero()
	{
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this, 0, 10);
		body.addBox(-3F, 0F, 0F, 6, 2, 8);
		body.addBox(-5F, -1F, -5F, 10, 4, 5);
		body.setRotationPoint(0F, 20F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		DDUtils.setRotation(body, 0F, 0F, 0F);
		legs = new ModelRenderer(this, 32, 15);
		legs.addBox(3F, 0F, -1F, 2, 5, 2);
		legs.addBox(-5F, 0F, -1F, 2, 5, 2);
		legs.setRotationPoint(0F, 21F, 6F);
		legs.setTextureSize(64, 32);
		legs.mirror = true;
		DDUtils.setRotation(legs, DDUtils.degToRad(90F), 0F, 0F);
		arm1 = new ModelRenderer(this, 26, 10);
		arm1.addBox(1F, -1F, -1F, 12, 2, 2);
		arm1.setRotationPoint(3F, 21F, -3F);
		arm1.setTextureSize(64, 32);
		arm1.mirror = true;
		DDUtils.setRotation(arm1, 0F, 0F, 0F);
		arm2 = new ModelRenderer(this, 26, 10);
		arm2.addBox(-13F, -1F, -1F, 12, 2, 2);
		arm2.setRotationPoint(-3F, 21F, -3F);
		arm2.setTextureSize(64, 32);
		arm2.mirror = true;
		DDUtils.setRotation(arm2, 0F, 0F, 0F);
		wing1 = new ModelRenderer(this, 0, 0);
		wing1.addBox(0F, -4F, 0F, 26, 9, 0);
		wing1.setRotationPoint(3F, 21.5F, 1F);
		wing1.setTextureSize(64, 32);
		wing1.mirror = false;
		DDUtils.setRotation(wing1, DDUtils.degToRad(90F), 0F, 0F);
		wing2 = new ModelRenderer(this, 0, 0);
		wing2.addBox(0F, -4F, 0F, 26, 9, 0);
		wing2.setRotationPoint(-3F, 21.5F, 1F);
		wing2.setTextureSize(64, 32);
		wing2.mirror = true;
		DDUtils.setRotation(wing2, DDUtils.degToRad(-90F), DDUtils.degToRad(180F), 0F);
		neck = new ModelRenderer(this, 32, 23);
		neck.addBox(-1F, -4F, -1F, 2, 4, 2);
		neck.setRotationPoint(0F, 21F, -5F);
		neck.setTextureSize(64, 32);
		neck.mirror = true;
		DDUtils.setRotation(neck, DDUtils.degToRad(90F), 0F, 0F);
		head = new ModelRenderer(this, 48, 15);
		head.addBox(-2F, -6F, -1F, 4, 6, 4);
		head.setRotationPoint(0F, 21F, -9F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		DDUtils.setRotation(head, DDUtils.degToRad(90F), 0F, 0F);
		head2 = new ModelRenderer(this, 30, 18);
		head2.addBox(-1F, -1F, 0F, 2, 2, 12);
		head2.setRotationPoint(0F, 17F, -7F); // arg2 was 19F arg3 was -11F
		head2.setTextureSize(64, 32);
		head2.mirror = false;
		DDUtils.setRotation(head2, DDUtils.degToRad(30F), 0F, 0F);      
		beak = new ModelRenderer(this, 54, 0);
		beak.addBox(-1F, -8F, -2F, 2, 8, 3);
		beak.setRotationPoint(0F, 15F, -8.0F); //arg3 was -8.0F
		beak.setTextureSize(64, 32);
		beak.mirror = true;
		DDUtils.setRotation(beak, DDUtils.degToRad(90F), 0F, 0F);

		// childs
		DDUtils.convertToChild(head, beak);
		DDUtils.convertToChild(head, head2);

		// initial rotation
		this.head.rotateAngleX = DDUtils.degToRad(125F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		legs.render(f5);
		arm1.render(f5);
		arm2.render(f5);
		wing1.render(f5);
		wing2.render(f5);
		neck.render(f5);
		head.render(f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		float flapSpeed = 0.4262F;
		if(entity.motionY < 0D)
		{
			flapSpeed = 0.1F;
		}
		this.arm1.rotateAngleZ = this.wing1.rotateAngleZ = MathHelper.cos((entity.ticksExisted + entity.getEntityId()) * flapSpeed + (float)Math.PI) * 0.9F;
		this.arm2.rotateAngleZ = this.wing2.rotateAngleZ = MathHelper.cos((entity.ticksExisted + entity.getEntityId()) * flapSpeed) * 0.9F; //inner float controls speed, outer float controls angle
		// DDUtils.spinZ(arm1); up-down
		// DDUtils.spinY(head); side-to-side

	}

}

