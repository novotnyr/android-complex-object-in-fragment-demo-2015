package sk.upjs.ics.android.complexobjectinfragment;

import android.app.Fragment;
import android.os.Bundle;

public class DataStoreFragment extends Fragment {
    private Object object;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
