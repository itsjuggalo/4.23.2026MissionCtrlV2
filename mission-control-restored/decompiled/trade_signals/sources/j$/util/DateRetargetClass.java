package j$.util;

import j$.time.Instant;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DateRetargetClass {
    public static Instant toInstant(Date date) {
        return Instant.R(date.getTime());
    }
}
