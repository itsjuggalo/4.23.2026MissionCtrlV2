package com.dexterous.flutterlocalnotifications.models;

import java.lang.reflect.Type;
import l4.AbstractC2177j;
import l4.InterfaceC2175h;
import l4.InterfaceC2176i;

/* JADX INFO: loaded from: classes.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class a implements InterfaceC2176i {
        @Override // l4.InterfaceC2176i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(AbstractC2177j abstractC2177j, Type type, InterfaceC2175h interfaceC2175h) {
            try {
                return ScheduleMode.valueOf(abstractC2177j.h());
            } catch (Exception unused) {
                return abstractC2177j.a() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
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
