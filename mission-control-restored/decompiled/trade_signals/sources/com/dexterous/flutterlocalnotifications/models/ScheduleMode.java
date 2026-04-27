package com.dexterous.flutterlocalnotifications.models;

import androidx.annotation.Keep;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@Keep
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class Deserializer implements h {
        @Override // com.google.gson.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(i iVar, Type type, g gVar) {
            try {
                return ScheduleMode.valueOf(iVar.h());
            } catch (Exception unused) {
                return iVar.a() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
            }
        }
    }

    public boolean useAlarmClock() {
        return this == alarmClock;
    }

    public boolean useAllowWhileIdle() {
        return this == exactAllowWhileIdle || this == inexactAllowWhileIdle;
    }

    public boolean useExactAlarm() {
        return this == exact || this == exactAllowWhileIdle;
    }
}
