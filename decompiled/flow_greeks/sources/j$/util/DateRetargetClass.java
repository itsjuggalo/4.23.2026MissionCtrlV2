package j$.util;

import j$.time.Instant;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DateRetargetClass {
    public static Instant toInstant(Date date) {
        long time = date.getTime();
        Instant instant = Instant.f13541c;
        long j10 = 1000;
        return Instant.s(Math.floorDiv(time, j10), ((int) Math.floorMod(time, j10)) * 1000000);
    }
}
