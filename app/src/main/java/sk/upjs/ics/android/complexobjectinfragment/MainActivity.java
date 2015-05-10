package sk.upjs.ics.android.complexobjectinfragment;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {
    public static final String DATA_STORE_FRAGMENT_TAG = "dataStoreFragment";

    private DataStoreFragment dataStoreFragment;

    private ReallyComplexActivityState reallyComplexActivityState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataStoreFragment();
        restoreStateFromDataStoreFragment();
    }

    private void initDataStoreFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        this.dataStoreFragment
                = (DataStoreFragment) fragmentManager.findFragmentByTag(DATA_STORE_FRAGMENT_TAG);
        if(this.dataStoreFragment == null) {
            this.dataStoreFragment = new DataStoreFragment();
            fragmentManager.beginTransaction()
                    .add(this.dataStoreFragment, DATA_STORE_FRAGMENT_TAG)
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        saveStateToDataStoreFragment();
        super.onDestroy();
    }

    private void restoreStateFromDataStoreFragment() {
        this.reallyComplexActivityState = (ReallyComplexActivityState) this.dataStoreFragment.getObject();
        if(this.reallyComplexActivityState == null) {
            this.reallyComplexActivityState = new ReallyComplexActivityState();
        }
        setTitle(Long.toString(this.reallyComplexActivityState.hashCode()));
    }


    private void saveStateToDataStoreFragment() {
        this.dataStoreFragment.setObject(this.reallyComplexActivityState);
    }
}
