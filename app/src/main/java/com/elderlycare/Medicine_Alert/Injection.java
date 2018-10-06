package com.elderlycare.Medicine_Alert;

import android.content.Context;
import android.support.annotation.NonNull;

public class Injection {
    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}
