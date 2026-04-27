package S1;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: S1.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0685u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0709x f4960c;

    public C0685u(C0709x c0709x, String str) {
        Objects.requireNonNull(c0709x);
        this.f4960c = c0709x;
        AbstractC0940s.e(str);
        this.f4958a = str;
        this.f4959b = -1L;
    }

    public final List a() {
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f4960c.w0().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f4958a, String.valueOf(this.f4959b)}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j4 = cursorQuery.getLong(0);
                        long j5 = cursorQuery.getLong(3);
                        boolean z4 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j4 > this.f4959b) {
                            this.f4959b = j4;
                        }
                        try {
                            zzhr zzhrVar = (zzhr) g7.W(zzhs.zzk(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhrVar.zzl(string);
                            zzhrVar.zzo(cursorQuery.getLong(2));
                            arrayList.add(new C0677t(j4, j5, z4, (zzhs) zzhrVar.zzbc()));
                        } catch (IOException e4) {
                            this.f4960c.f4245a.a().o().c("Data loss. Failed to merge raw event. appId", C2.x(this.f4958a), e4);
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    arrayList = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e5) {
                this.f4960c.f4245a.a().o().c("Data loss. Error querying raw events batch. appId", C2.x(this.f4958a), e5);
            }
            return arrayList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public C0685u(C0709x c0709x, String str, long j4) {
        Objects.requireNonNull(c0709x);
        this.f4960c = c0709x;
        AbstractC0940s.e(str);
        this.f4958a = str;
        this.f4959b = c0709x.f0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j4)}, -1L);
    }
}
