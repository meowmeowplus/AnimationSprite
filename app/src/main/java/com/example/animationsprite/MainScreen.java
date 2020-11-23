package com.example.animationsprite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainScreen extends View {
    static final int ANGRY = 1, BABY = 2, HAPPY = 3, MAKEFRIEND = 4, TERRORIZED = 5, UPSET = 6;
    private SettingIconSprite settingIconSprite;
    private SettingMenuSprite settingMenuSprite;
    private TypeSwitchSprite typeSwitchSprite;
    private AnimationSprite angryAnimationSprite;
    private AnimationSprite babyAnimationSprite;
    private AnimationSprite terrorizedAnimationSprite;
    private AnimationSprite upsetAnimationSprite;
    private AnimationSprite makefriendAnimationSprite;
    private AnimationSprite happyAnimationSprite;
//    private ArrayList<Media> medias;
//    private MediaPlayer media;

    private int screenWidth, screenHeight;

    private float xDown, yDown;
    private float singleClickArea = 200;

    public MainScreen(Context context, int width, int height) {
        super(context);
        this.screenWidth = width;
        this.screenHeight = height;

        createSettingIcon();
        createSettingMenu();
        createSwitchTypeButton();
        resetDownClickPosition();
        createAnimationAndSound();
    }



    private void createSettingIcon() {
        int length = screenWidth / 6;
        settingIconSprite = new SettingIconSprite(
                getContext(),
                0,
                screenWidth - length,
                length
        );

        settingIconSprite.addBmp(new int[] {
                R.drawable.setting_icon
        });
    }

    private void createSettingMenu() {
        int width = (int)(screenWidth / 1.2);
        int height = screenHeight - settingIconSprite.getLength() * 2;
        settingMenuSprite = new SettingMenuSprite(
                getContext(),
                (float)(screenHeight - height) / 2,
                (float)(screenWidth - width) / 2,
                width, height
        );

        settingMenuSprite.setMenuBmp(R.drawable.menu_background);
        settingMenuSprite.setMenuTextBmp(new int[] {
                R.drawable.setting_text
        });
        settingMenuSprite.setModeButtonBmp(new int[]{
                R.drawable.mode_1,
                R.drawable.mode_2
        });
        settingMenuSprite.setSoundButtonBmp(new int[]{
                R.drawable.sound_1,
                R.drawable.sound_2
        });
        settingMenuSprite.setCreditButtonBmp(new int[]{
                R.drawable.credit_1
        });
    }

    private void createSwitchTypeButton() {
        typeSwitchSprite = new TypeSwitchSprite(
                getContext(),
                screenWidth,
                screenHeight,
                2
        );

        typeSwitchSprite.addBmp(new int[]{
                R.drawable.type_0,
                R.drawable.type_1,
                R.drawable.type_2
        });

        typeSwitchSprite.addTypeIcon(new int[]{
                R.drawable.type_icon_1_1, R.drawable.type_icon_1_2,
                R.drawable.type_icon_2_1, R.drawable.type_icon_2_2
        });
    }

    private void createAnimationAndSound() {
        angryAnimationSprite = new AnimationSprite(
                getContext(),
                this,
                screenWidth/6,
                screenHeight/10,
                screenWidth/5,
                screenHeight/10
        );
        angryAnimationSprite.addBmp(new int[]{
                R.drawable.angry1,
                R.drawable.angry2,
                R.drawable.angry3,
                R.drawable.angry4,
                R.drawable.angry5,
                R.drawable.angry6,
                R.drawable.angry7,
                R.drawable.angry8,
                R.drawable.angry9,
                R.drawable.angry10,
                R.drawable.angry11,
                R.drawable.angry12,
                R.drawable.angry13,
                R.drawable.angry14,
                R.drawable.angry15,
                R.drawable.angry16,
                R.drawable.angry17,
                R.drawable.angry18,
                R.drawable.angry19,
                R.drawable.angry20,
                R.drawable.angry21,
                R.drawable.angry22,
                R.drawable.angry23,
        });

        babyAnimationSprite = new AnimationSprite(
                getContext(),
                this,
                screenWidth/6*2,
                screenHeight/10,
                screenWidth/5,
                screenHeight/10
        );
        babyAnimationSprite.addBmp(new int[]{
                R.drawable.baby1,
                R.drawable.baby2,
                R.drawable.baby3,
                R.drawable.baby4,
                R.drawable.baby5,
                R.drawable.baby6,
                R.drawable.baby7,
                R.drawable.baby8,
                R.drawable.baby9,
                R.drawable.baby10,
                R.drawable.baby11,
                R.drawable.baby12,
                R.drawable.baby13,
                R.drawable.baby14,
                R.drawable.baby15,
                R.drawable.baby16,
                R.drawable.baby17,
                R.drawable.baby18,
        });

        happyAnimationSprite = new AnimationSprite(
                        getContext(),
                        this,
                        screenWidth/6*3,
                        screenHeight/10,
                        screenWidth/5,
                        screenHeight/10
                );
        happyAnimationSprite.addBmp(new int[]{
                R.drawable.happy1,
                R.drawable.happy2,
                R.drawable.happy3,
                R.drawable.happy4,
                R.drawable.happy5,
                R.drawable.happy6,
                R.drawable.happy7,
                R.drawable.happy8,
                R.drawable.happy9,
                R.drawable.happy10,
                R.drawable.happy11,
                R.drawable.happy12,
                R.drawable.happy13,
                R.drawable.happy14,
                R.drawable.happy15,
                R.drawable.happy16,
                R.drawable.happy17,
                R.drawable.happy18,
                R.drawable.happy19,
                R.drawable.happy20,
                R.drawable.happy21,
                R.drawable.happy22,
                R.drawable.happy23,
                R.drawable.happy24,
                R.drawable.happy25,
                R.drawable.happy26,
                R.drawable.happy27,
                R.drawable.happy28,
                R.drawable.happy29,
                R.drawable.happy30,
                R.drawable.happy31,
                R.drawable.happy32,
                R.drawable.happy33,
                R.drawable.happy34,
                R.drawable.happy35,
                R.drawable.happy36,
                R.drawable.happy37,
        });

        makefriendAnimationSprite = new AnimationSprite(
                        getContext(),
                        this,
                        screenWidth/6*4,
                        screenHeight/10,
                        screenWidth/5,
                        screenHeight/10
                );
        makefriendAnimationSprite.addBmp(new int[]{
                R.drawable.makefriend0,
                R.drawable.makefriend1,
                R.drawable.makefriend2,
                R.drawable.makefriend3,
                R.drawable.makefriend4,
                R.drawable.makefriend5,
                R.drawable.makefriend6,
                R.drawable.makefriend7,
        });

        terrorizedAnimationSprite = new AnimationSprite(
                        getContext(),
                        this,
                        screenWidth/6*5,
                        screenHeight/10,
                        screenWidth/5,
                        screenHeight/10
                );
        terrorizedAnimationSprite.addBmp(new int[]{
                R.drawable.terrorized0,
                R.drawable.terrorized1,
                R.drawable.terrorized2,
                R.drawable.terrorized3,
                R.drawable.terrorized4,
        });

        upsetAnimationSprite = new AnimationSprite(
                        getContext(),
                        this,
                        screenWidth/6*6,
                        screenHeight/10,
                        screenWidth/5,
                        screenHeight/10
                );
        upsetAnimationSprite.addBmp(new int[]{
                R.drawable.upset1,
                R.drawable.upset2,
                R.drawable.upset3,
                R.drawable.upset4,
                R.drawable.upset5,
                R.drawable.upset6,
                R.drawable.upset7,
                R.drawable.upset8,
                R.drawable.upset9,
                R.drawable.upset10,
                R.drawable.upset11,
                R.drawable.upset12,
                R.drawable.upset13,
                R.drawable.upset14,
                R.drawable.upset15,
                R.drawable.upset16,
                R.drawable.upset17,
                R.drawable.upset18,
                R.drawable.upset19,
                R.drawable.upset20,
                R.drawable.upset21,
                R.drawable.upset22,
                R.drawable.upset23,
                R.drawable.upset24,
                R.drawable.upset25,
                R.drawable.upset26,
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        typeSwitchSprite.draw(canvas);
        angryAnimationSprite.draw(canvas);
        babyAnimationSprite.draw(canvas);
        makefriendAnimationSprite.draw(canvas);
        happyAnimationSprite.draw(canvas);
        terrorizedAnimationSprite.draw(canvas);
        upsetAnimationSprite.draw(canvas);
        settingIconSprite.draw(canvas);
        if (settingIconSprite.isTurnedOn)
        {
            settingMenuSprite.draw(canvas);
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int eventAction = event.getActionMasked();
        Log.d("@@@@", "Action: " + eventAction);
        switch (eventAction)
        {
            case MotionEvent.ACTION_DOWN:
                xDown = x;
                yDown = y;
                handleTypeSelect();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isSingleClick(x, y))
                    resetDownClickPosition();
                break;
            case MotionEvent.ACTION_UP:
                if (isSingleClick(x, y))
                    handleSingleClick(x, y);
                else
                {
                    typeSwitchSprite.update(0);
                    invalidate();
                }
                break;
        }
        return true;
    }

    private void resetDownClickPosition() {
        xDown = -1000;
        yDown = -1000;
    }

    private void handleTypeSelect() {
        if (typeSwitchSprite.isSelected(xDown, yDown))
        {
            typeSwitchSprite.handleSelected(xDown, yDown);
            invalidate();
        }
    }

    private void handleSingleClick(float x, float y) {
        if (settingIconSprite.isTurnedOn)
            handleSettingMenuClick(x, y);
        else if (angryAnimationSprite.isSelected(x,y))
            handleAnimationClick(angryAnimationSprite,x,y);
        else if (babyAnimationSprite.isSelected(x,y))
            handleAnimationClick(babyAnimationSprite,x,y);
        else if (upsetAnimationSprite.isSelected(x,y))
            handleAnimationClick(upsetAnimationSprite,x,y);
        else if (terrorizedAnimationSprite.isSelected(x,y))
            handleAnimationClick(terrorizedAnimationSprite,x,y);
        else if (happyAnimationSprite.isSelected(x,y))
            handleAnimationClick(happyAnimationSprite,x,y);
        else if (makefriendAnimationSprite.isSelected(x,y))
            handleAnimationClick(makefriendAnimationSprite,x,y);
        else if (settingIconSprite.isSelected(x, y))
            settingIconSprite.isTurnedOn = true;
        else if (typeSwitchSprite.isSelected(x, y))
            typeSwitchSprite.handleButtonClick(x, y);
        else
            return;
        invalidate();
    }

    private void handleAnimationClick(AnimationSprite animationSprite, float x, float y) {
        if(!animationSprite.isTurnedOn)
            animationSprite.isTurnedOn = true;
        else
            animationSprite.isTurnedOn = false;
        animationSprite.handleClick(getContext());
    }

    private void handleSettingMenuClick(float x, float y) {
        if (!settingMenuSprite.isSelected(x, y))
            settingIconSprite.isTurnedOn = false;
        else
            settingMenuSprite.handleButtonsClick(x, y);
    }

    private boolean isSingleClick(float x, float y) {
        return Math.abs(x - xDown) <= singleClickArea && Math.abs(y - yDown) <= singleClickArea;
    }
}
