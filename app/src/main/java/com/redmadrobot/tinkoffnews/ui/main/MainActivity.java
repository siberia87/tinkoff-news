package com.redmadrobot.tinkoffnews.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.redmadrobot.tinkoffnews.App;
import com.redmadrobot.tinkoffnews.R;
import com.redmadrobot.tinkoffnews.presentations.launch.LaunchPresenter;
import com.redmadrobot.tinkoffnews.presentations.launch.LaunchView;
import com.redmadrobot.tinkoffnews.ui.global.BaseActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

public class MainActivity extends BaseActivity implements LaunchView {

    @InjectPresenter
    LaunchPresenter mPresenter;

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        App.getInstance().getDagger().getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNavigatorHolder.removeNavigator();
    }

    private SupportAppNavigator mNavigator = new SupportAppNavigator(this, R.id.mainContainer) {

        @Override
        public void applyCommand(final Command command) {
            super.applyCommand(command);
            if (command instanceof Forward) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.mainContainer, createFragment(
                                ((Forward) command).getScreenKey(),
                                ((Forward) command).getTransitionData())
                        )
                        .addToBackStack(((Forward) command).getScreenKey())
                        .commit();
            }
        }

        @Override
        protected Fragment createFragment(final String screenKey, final Object data) {
            return null;
        }

        @Override
        protected Intent createActivityIntent(final String screenKey, final Object data) {
            return null;
        }
    };
}
