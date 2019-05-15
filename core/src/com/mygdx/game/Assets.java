package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets extends AssetManager {
    public TextureAtlas atlas;
    public Animation<TextureRegion> space, alien, aliendie, naveidle, naveleft, naveright, naveshoot, shoot ,alienshoot;
    public Sound shootSound = Gdx.audio.newSound(Gdx.files.internal("shootsound.wav"));
    public Sound alienSound = Gdx.audio.newSound(Gdx.files.internal("aliensound.wav"));
    public Sound aliendieSound = Gdx.audio.newSound(Gdx.files.internal("aliendie.wav"));

    public void load(){
        load("invaders.atlas", TextureAtlas.class);
    }

    @Override
    public synchronized boolean update() {
        boolean update = super.update();

        if(update){
            atlas = get("invaders.atlas", TextureAtlas.class);

            loadAnimations();
        }
        return update;
    }

    void loadAnimations(){
        space = new Animation<TextureRegion>(1f, atlas.findRegions("space"));
        alien = new Animation<TextureRegion>(0.4f, atlas.findRegions("alien"));
        aliendie = new Animation<TextureRegion>(0.05f, atlas.findRegions("aliendie"));
        naveidle = new Animation<TextureRegion>(0.1f, atlas.findRegions("naveidle"));
        naveleft = new Animation<TextureRegion>(0.1f, atlas.findRegions("naveleft"));
        naveright = new Animation<TextureRegion>(0.1f, atlas.findRegions("naveright"));
        naveshoot = new Animation<TextureRegion>(0.1f, atlas.findRegions("naveshoot"));
        shoot = new Animation<TextureRegion>(0.02f, atlas.findRegions("shoot"));
        alienshoot = new Animation<TextureRegion>(0.1f, atlas.findRegions("alienshoot"));
    }
}
