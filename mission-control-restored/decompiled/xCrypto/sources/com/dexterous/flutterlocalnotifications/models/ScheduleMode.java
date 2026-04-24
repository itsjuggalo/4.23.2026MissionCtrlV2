package com.dexterous.flutterlocalnotifications.models;

import java.lang.reflect.Type;
import q2.h;
import q2.i;
import q2.j;

/* JADX INFO: loaded from: classes.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class a implements i {
        @Override // q2.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(j jVar, Type type, h hVar) {
            try {
                return ScheduleMode.valueOf(jVar.l());
            } catch (Exception unused) {
                return jVar.c() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
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
