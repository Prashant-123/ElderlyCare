package com.elderlycare.Medicine_Alert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elderlycare.R;

public class AddMedicine extends AppCompatActivity {


    public static final int REQUEST_ADD_TASK = 1;

    public static final String SHOULD_LOAD_DATA_FROM_REPO_KEY = "SHOULD_LOAD_DATA_FROM_REPO_KEY";

    public static final String EXTRA_TASK_ID = "task_extra_id";
    public static final String EXTRA_TASK_NAME = "task_extra_name";

    private AddMedicinePresenter mAddMedicinePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        AddMedicineFragment addMedicineFragment = (AddMedicineFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        int medId = getIntent().getIntExtra(AddMedicineFragment.ARGUMENT_EDIT_MEDICINE_ID,0);
        String medName = getIntent().getStringExtra(AddMedicineFragment.ARGUMENT_EDIT_MEDICINE_NAME);

        if (addMedicineFragment == null) {
            addMedicineFragment = AddMedicineFragment.newInstance();

            if (getIntent().hasExtra(AddMedicineFragment.ARGUMENT_EDIT_MEDICINE_ID)) {
                Bundle bundle = new Bundle();
                bundle.putInt(AddMedicineFragment.ARGUMENT_EDIT_MEDICINE_ID, medId);
                addMedicineFragment.setArguments(bundle);
            }
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addMedicineFragment, R.id.contentFrame);
        }

        boolean shouldLoadDataFromRepo = true;
        if (savedInstanceState != null) {
            shouldLoadDataFromRepo = savedInstanceState.getBoolean(SHOULD_LOAD_DATA_FROM_REPO_KEY);
        }

        mAddMedicinePresenter = new AddMedicinePresenter(
                medId,
                Injection.provideMedicineRepository(getApplicationContext()),
                addMedicineFragment,
                shouldLoadDataFromRepo);

    }
}
