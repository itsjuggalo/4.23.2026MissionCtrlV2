package S1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzql;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: S1.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0709x extends M6 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f5024f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f5025g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f5026h = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f5027i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f5028j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f5029k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f5030l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f5031m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f5032n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f5033o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f5034p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0693v f5035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final A6 f5036e;

    public C0709x(b7 b7Var) {
        super(b7Var);
        this.f5036e = new A6(this.f4245a.f());
        this.f4245a.w();
        this.f5035d = new C0693v(this, this.f4245a.e(), "google_app_measurement.db");
    }

    public static final String V(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    public static final void s0(ContentValues contentValues, String str, Object obj) {
        AbstractC0940s.e("value");
        AbstractC0940s.k(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public final long A() {
        return N("select max(timestamp) from raw_events", null, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.A0(java.lang.String):void");
    }

    public final boolean B() {
        return M("select count(1) > 0 from raw_events", null) != 0;
    }

    public final void B0(String str, String str2) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        h();
        j();
        try {
            w0().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e4) {
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().o().d("Error deleting user property. appId", C2.x(str), c0658q3.D().c(str2), e4);
        }
    }

    public final boolean C(String str, String str2) {
        return M("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean C0(j7 j7Var) {
        AbstractC0940s.k(j7Var);
        h();
        j();
        String str = j7Var.f4706a;
        String str2 = j7Var.f4708c;
        if (D0(str, str2) == null) {
            if (l7.r0(str2)) {
                if (M("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.f4245a.w().F(str, AbstractC0569f2.f4546W, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jM = M("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, j7Var.f4707b});
                this.f4245a.w();
                if (jM >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, j7Var.f4707b);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(j7Var.f4709d));
        s0(contentValues, "value", j7Var.f4710e);
        try {
            if (w0().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.f4245a.a().o().b("Failed to insert/update user property (got -1). appId", C2.x(str));
            return true;
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing user property. appId", C2.x(j7Var.f4706a), e4);
            return true;
        }
    }

    public final boolean D() {
        return M("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.j7 D0(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.AbstractC0940s.e(r11)
            com.google.android.gms.common.internal.AbstractC0940s.e(r12)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.w0()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L79
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            if (r0 != 0) goto L32
            goto L99
        L32:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            r0 = 1
            java.lang.Object r9 = r10.x(r2, r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            if (r9 != 0) goto L40
            goto L99
        L40:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            S1.j7 r3 = new S1.j7     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L70
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            boolean r11 = r2.moveToNext()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            if (r11 == 0) goto L6c
            S1.q3 r11 = r10.f4245a     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            S1.C2 r11 = r11.a()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            S1.A2 r11 = r11.o()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = S1.C2.x(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            r11.b(r12, r0)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            goto L6c
        L66:
            r0 = move-exception
            r11 = r0
            goto L74
        L69:
            r0 = move-exception
        L6a:
            r11 = r0
            goto L7e
        L6c:
            r2.close()
            return r3
        L70:
            r0 = move-exception
            r4 = r11
            r6 = r12
            goto L6a
        L74:
            r1 = r2
            goto L9f
        L76:
            r0 = move-exception
            r11 = r0
            goto L9f
        L79:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L7e:
            S1.q3 r12 = r10.f4245a     // Catch: java.lang.Throwable -> L66
            S1.C2 r0 = r12.a()     // Catch: java.lang.Throwable -> L66
            S1.A2 r0 = r0.o()     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = S1.C2.x(r4)     // Catch: java.lang.Throwable -> L66
            S1.v2 r12 = r12.D()     // Catch: java.lang.Throwable -> L66
            java.lang.String r12 = r12.c(r6)     // Catch: java.lang.Throwable -> L66
            r0.d(r3, r4, r12, r11)     // Catch: java.lang.Throwable -> L66
        L99:
            if (r2 == 0) goto L9e
            r2.close()
        L9e:
            return r1
        L9f:
            if (r1 == 0) goto La4
            r1.close()
        La4:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.D0(java.lang.String, java.lang.String):S1.j7");
    }

    public final void E(List list) {
        AbstractC0940s.k(list);
        h();
        j();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(((Long) list.get(i4)).longValue());
        }
        sb.append(")");
        int iDelete = w0().delete("raw_events", sb.toString(), null);
        if (iDelete != list.size()) {
            this.f4245a.a().o().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
        }
    }

    public final List E0(String str) {
        String str2;
        AbstractC0940s.e(str);
        h();
        j();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                C0658q3 c0658q3 = this.f4245a;
                c0658q3.w();
                cursorQuery = w0().query("user_attributes", new String[]{"name", FirebaseAnalytics.Param.ORIGIN, "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            if (string2 == null) {
                                string2 = "";
                            }
                            String str3 = string2;
                            long j4 = cursorQuery.getLong(2);
                            Object objX = x(cursorQuery, 3);
                            if (objX == null) {
                                c0658q3.a().o().b("Read invalid user property value, ignoring it. appId", C2.x(str));
                                str2 = str;
                            } else {
                                str2 = str;
                                try {
                                    arrayList.add(new j7(str2, str3, string, j4, objX));
                                } catch (SQLiteException e4) {
                                    e = e4;
                                    this.f4245a.a().o().c("Error querying user properties. appId", C2.x(str2), e);
                                    arrayList = Collections.EMPTY_LIST;
                                }
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            str = str2;
                        }
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    str2 = str;
                }
            } catch (SQLiteException e6) {
                e = e6;
                str2 = str;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    public final void F(String str) {
        try {
            w0().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Failed to remove unused event metadata. appId", C2.x(str), e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        r0 = r8.a().o();
        r8.w();
        r0.b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List F0(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.F0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final long G(String str) {
        AbstractC0940s.e(str);
        return N("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean G0(C0590i c0590i) {
        AbstractC0940s.k(c0590i);
        h();
        j();
        String str = c0590i.f4667a;
        AbstractC0940s.k(str);
        if (D0(str, c0590i.f4669c.f4661b) == null) {
            long jM = M("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f4245a.w();
            if (jM >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, c0590i.f4668b);
        contentValues.put("name", c0590i.f4669c.f4661b);
        s0(contentValues, "value", AbstractC0940s.k(c0590i.f4669c.i()));
        contentValues.put("active", Boolean.valueOf(c0590i.f4671e));
        contentValues.put("trigger_event_name", c0590i.f4672f);
        contentValues.put("trigger_timeout", Long.valueOf(c0590i.f4674h));
        C0658q3 c0658q3 = this.f4245a;
        contentValues.put("timed_out_event", c0658q3.C().T(c0590i.f4673g));
        contentValues.put("creation_timestamp", Long.valueOf(c0590i.f4670d));
        contentValues.put("triggered_event", c0658q3.C().T(c0590i.f4675i));
        contentValues.put("triggered_timestamp", Long.valueOf(c0590i.f4669c.f4662c));
        contentValues.put("time_to_live", Long.valueOf(c0590i.f4676j));
        contentValues.put("expired_event", c0658q3.C().T(c0590i.f4677k));
        try {
            if (w0().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            c0658q3.a().o().b("Failed to insert/update conditional user property (got -1)", C2.x(str));
            return true;
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing conditional user property", C2.x(str), e4);
            return true;
        }
    }

    public final boolean H(String str, Long l4, long j4, zzhs zzhsVar) {
        h();
        j();
        AbstractC0940s.k(zzhsVar);
        AbstractC0940s.e(str);
        AbstractC0940s.k(l4);
        C0658q3 c0658q3 = this.f4245a;
        byte[] bArrZzcc = zzhsVar.zzcc();
        c0658q3.a().w().c("Saving complex main event, appId, data size", c0658q3.D().a(str), Integer.valueOf(bArrZzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l4);
        contentValues.put("children_to_process", Long.valueOf(j4));
        contentValues.put("main_event", bArrZzcc);
        try {
            if (w0().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            c0658q3.a().o().b("Failed to insert complex main event (got -1). appId", C2.x(str));
            return false;
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing complex main event. appId", C2.x(str), e4);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00f6: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:247), block:B:29:0x00f6 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.C0590i H0(java.lang.String r26, java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.H0(java.lang.String, java.lang.String):S1.i");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:107), block:B:19:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle I(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.h()
            r5.j()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.w0()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            if (r2 != 0) goto L2f
            S1.q3 r6 = r5.f4245a     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            S1.C2 r6 = r6.a()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            S1.A2 r6 = r6.w()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.lang.String r2 = "Default event parameters not found"
            r6.a(r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            goto L7f
        L2b:
            r6 = move-exception
            goto L6a
        L2d:
            r6 = move-exception
            goto L70
        L2f:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            com.google.android.gms.internal.measurement.zzhr r3 = com.google.android.gms.internal.measurement.zzhs.zzk()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zznk r2 = S1.g7.W(r3, r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzme r2 = r2.zzbc()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d java.io.IOException -> L55
            S1.b7 r6 = r5.f3955b     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r6.K0()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.util.List r6 = r2.zza()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            android.os.Bundle r6 = S1.g7.q(r6)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r1.close()
            return r6
        L55:
            r2 = move-exception
            S1.q3 r3 = r5.f4245a     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            S1.C2 r3 = r3.a()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            S1.A2 r3 = r3.o()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = S1.C2.x(r6)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            r3.c(r4, r6, r2)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2d
            goto L7f
        L6a:
            r0 = r1
            goto L85
        L6c:
            r6 = move-exception
            goto L85
        L6e:
            r6 = move-exception
            r1 = r0
        L70:
            S1.q3 r2 = r5.f4245a     // Catch: java.lang.Throwable -> L2b
            S1.C2 r2 = r2.a()     // Catch: java.lang.Throwable -> L2b
            S1.A2 r2 = r2.o()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r6)     // Catch: java.lang.Throwable -> L2b
        L7f:
            if (r1 == 0) goto L84
            r1.close()
        L84:
            return r0
        L85:
            if (r0 == 0) goto L8a
            r0.close()
        L8a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.I(java.lang.String):android.os.Bundle");
    }

    public final int I0(String str, String str2) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        h();
        j();
        try {
            return w0().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e4) {
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().o().d("Error deleting conditional property", C2.x(str), c0658q3.D().c(str2), e4);
            return 0;
        }
    }

    public final boolean J(String str, long j4) {
        try {
            if (N("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j4)}, 0L) > 0) {
                return false;
            }
            return N("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j4)}, 0L) > 0;
        } catch (SQLiteException e4) {
            this.f4245a.a().o().b("Error checking backfill conditions", e4);
            return false;
        }
    }

    public final List J0(String str, String str2, String str3) {
        AbstractC0940s.e(str);
        h();
        j();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return K0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(java.lang.String r25, java.lang.Long r26, java.lang.String r27, android.os.Bundle r28) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.K(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        r2 = r12.a().o();
        r12.w();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List K0(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.K0(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.C0531a4 L(java.lang.String r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.AbstractC0940s.k(r5)
            r4.h()
            r4.j()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.w0()     // Catch: java.lang.Throwable -> L46 android.database.sqlite.SQLiteException -> L49
            android.database.Cursor r5 = r2.rawQuery(r0, r5)     // Catch: java.lang.Throwable -> L46 android.database.sqlite.SQLiteException -> L49
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            if (r0 != 0) goto L35
            S1.q3 r0 = r4.f4245a     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            S1.C2 r0 = r0.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            S1.A2 r0 = r0.w()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            java.lang.String r2 = "No data found"
            r0.a(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
        L2d:
            r5.close()
            goto L5e
        L31:
            r0 = move-exception
            goto L44
        L33:
            r0 = move-exception
            goto L4c
        L35:
            r0 = 0
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            r2 = 1
            int r2 = r5.getInt(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            S1.a4 r1 = S1.C0531a4.f(r0, r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteException -> L33
            goto L2d
        L44:
            r1 = r5
            goto L64
        L46:
            r5 = move-exception
            r0 = r5
            goto L64
        L49:
            r5 = move-exception
            r0 = r5
            r5 = r1
        L4c:
            S1.q3 r2 = r4.f4245a     // Catch: java.lang.Throwable -> L31
            S1.C2 r2 = r2.a()     // Catch: java.lang.Throwable -> L31
            S1.A2 r2 = r2.o()     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "Error querying database."
            r2.b(r3, r0)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L5e
            goto L2d
        L5e:
            if (r1 != 0) goto L63
            S1.a4 r5 = S1.C0531a4.f4335c
            return r5
        L63:
            return r1
        L64:
            if (r1 == 0) goto L69
            r1.close()
        L69:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.L(java.lang.String):S1.a4");
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0306  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.J2 L0(java.lang.String r52) {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.L0(java.lang.String):S1.J2");
    }

    public final long M(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = w0().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j4 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j4;
            } catch (SQLiteException e4) {
                this.f4245a.a().o().c("Database error", str, e4);
                throw e4;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void M0(J2 j22, boolean z4, boolean z5) {
        AbstractC0940s.k(j22);
        h();
        j();
        String strO0 = j22.o0();
        AbstractC0940s.k(strO0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strO0);
        if (z4) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.f3955b.g(strO0).o(Z3.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", j22.p0());
        }
        contentValues.put("gmp_app_id", j22.r0());
        b7 b7Var = this.f3955b;
        if (b7Var.g(strO0).o(Z3.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", j22.v0());
        }
        contentValues.put("last_bundle_index", Long.valueOf(j22.g()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(j22.z0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(j22.B0()));
        contentValues.put("app_version", j22.D0());
        contentValues.put("app_store", j22.H0());
        contentValues.put("gmp_version", Long.valueOf(j22.J0()));
        contentValues.put("dev_cert_hash", Long.valueOf(j22.L0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(j22.d()));
        contentValues.put("day", Long.valueOf(j22.n()));
        contentValues.put("daily_public_events_count", Long.valueOf(j22.p()));
        contentValues.put("daily_events_count", Long.valueOf(j22.r()));
        contentValues.put("daily_conversions_count", Long.valueOf(j22.t()));
        contentValues.put("config_fetched_time", Long.valueOf(j22.h()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(j22.j()));
        contentValues.put("app_version_int", Long.valueOf(j22.F0()));
        contentValues.put("firebase_instance_id", j22.x0());
        contentValues.put("daily_error_events_count", Long.valueOf(j22.x()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(j22.v()));
        contentValues.put("health_monitor_sample", j22.z());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(j22.P()));
        contentValues.put("dynamite_version", Long.valueOf(j22.b()));
        if (b7Var.g(strO0).o(Z3.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", j22.t0());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(j22.V()));
        contentValues.put("target_os_version", Long.valueOf(j22.X()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(j22.Z()));
        zzql.zza();
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.w().H(strO0, AbstractC0569f2.f4535Q0)) {
            contentValues.put("ad_services_version", Integer.valueOf(j22.b0()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(j22.j0()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(j22.d0()));
        contentValues.put("npa_metadata_value", j22.R());
        contentValues.put("bundle_delivery_index", Long.valueOf(j22.G()));
        contentValues.put("sgtm_preview_key", j22.l0());
        contentValues.put("dma_consent_state", Integer.valueOf(j22.B()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(j22.D()));
        contentValues.put("serialized_npa_metadata", j22.I());
        contentValues.put("client_upload_eligibility", Integer.valueOf(j22.M()));
        List listT = j22.T();
        if (listT != null) {
            if (listT.isEmpty()) {
                c0658q3.a().r().b("Safelisted events should not be an empty list. appId", strO0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(com.amazon.a.a.o.b.f.f8804a, listT));
            }
        }
        zzpn.zza();
        if (c0658q3.w().H(null, AbstractC0569f2.f4525L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", j22.f0());
        contentValues.put("unmatched_uwa", j22.h0());
        contentValues.put("ad_campaign_info", j22.K());
        try {
            SQLiteDatabase sQLiteDatabaseW0 = w0();
            if (sQLiteDatabaseW0.update("apps", contentValues, "app_id = ?", new String[]{strO0}) == 0 && sQLiteDatabaseW0.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                c0658q3.a().o().b("Failed to insert/update app (got -1). appId", C2.x(strO0));
            }
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing app. appId", C2.x(strO0), e4);
        }
    }

    public final long N(String str, String[] strArr, long j4) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = w0().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j4 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j4;
            } catch (SQLiteException e4) {
                this.f4245a.a().o().c("Database error", str, e4);
                throw e4;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final C0669s N0(long j4, String str, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        return O0(j4, str, 1L, false, false, z6, false, z8, z9, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String O(java.lang.String r3, java.lang.String[] r4, java.lang.String r5) {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r5 = r2.w0()
            r0 = 0
            android.database.Cursor r0 = r5.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            boolean r4 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            if (r4 == 0) goto L1c
            r4 = 0
            java.lang.String r3 = r0.getString(r4)     // Catch: java.lang.Throwable -> L18 android.database.sqlite.SQLiteException -> L1a
            r0.close()
            return r3
        L18:
            r3 = move-exception
            goto L32
        L1a:
            r4 = move-exception
            goto L22
        L1c:
            r0.close()
            java.lang.String r3 = ""
            return r3
        L22:
            S1.q3 r5 = r2.f4245a     // Catch: java.lang.Throwable -> L18
            S1.C2 r5 = r5.a()     // Catch: java.lang.Throwable -> L18
            S1.A2 r5 = r5.o()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "Database error"
            r5.c(r1, r3, r4)     // Catch: java.lang.Throwable -> L18
            throw r4     // Catch: java.lang.Throwable -> L18
        L32:
            if (r0 == 0) goto L37
            r0.close()
        L37:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.O(java.lang.String, java.lang.String[], java.lang.String):java.lang.String");
    }

    public final C0669s O0(long j4, String str, long j5, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        AbstractC0940s.e(str);
        h();
        j();
        String[] strArr = {str};
        C0669s c0669s = new C0669s();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseW0 = w0();
                cursorQuery = sQLiteDatabaseW0.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j4) {
                        c0669s.f4908b = cursorQuery.getLong(1);
                        c0669s.f4907a = cursorQuery.getLong(2);
                        c0669s.f4909c = cursorQuery.getLong(3);
                        c0669s.f4910d = cursorQuery.getLong(4);
                        c0669s.f4911e = cursorQuery.getLong(5);
                        c0669s.f4912f = cursorQuery.getLong(6);
                        c0669s.f4913g = cursorQuery.getLong(7);
                    }
                    if (z4) {
                        c0669s.f4908b += j5;
                    }
                    if (z5) {
                        c0669s.f4907a += j5;
                    }
                    if (z6) {
                        c0669s.f4909c += j5;
                    }
                    if (z7) {
                        c0669s.f4910d += j5;
                    }
                    if (z8) {
                        c0669s.f4911e += j5;
                    }
                    if (z9) {
                        c0669s.f4912f += j5;
                    }
                    if (z10) {
                        c0669s.f4913g += j5;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j4));
                    contentValues.put("daily_public_events_count", Long.valueOf(c0669s.f4907a));
                    contentValues.put("daily_events_count", Long.valueOf(c0669s.f4908b));
                    contentValues.put("daily_conversions_count", Long.valueOf(c0669s.f4909c));
                    contentValues.put("daily_error_events_count", Long.valueOf(c0669s.f4910d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(c0669s.f4911e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(c0669s.f4912f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(c0669s.f4913g));
                    sQLiteDatabaseW0.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    this.f4245a.a().r().b("Not updating daily counts, app is not known. appId", C2.x(str));
                }
            } catch (SQLiteException e4) {
                this.f4245a.a().o().c("Error updating daily counts. appId", C2.x(str), e4);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return c0669s;
        } finally {
        }
    }

    public final void P(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseW0 = w0();
            if (contentValues.getAsString("app_id") == null) {
                this.f4245a.a().q().b("Value of the primary key is not set.", C2.x("app_id"));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append("app_id");
            sb.append(" = ?");
            if (sQLiteDatabaseW0.update("consent_settings", contentValues, sb.toString(), new String[]{r2}) == 0 && sQLiteDatabaseW0.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.f4245a.a().o().c("Failed to insert/update table (got -1). key", C2.x("consent_settings"), C2.x("app_id"));
            }
        } catch (SQLiteException e4) {
            this.f4245a.a().o().d("Error storing into table. key", C2.x("consent_settings"), C2.x("app_id"), e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.r P0(java.lang.String r11) throws java.lang.Throwable {
        /*
            r10 = this;
            com.google.android.gms.common.internal.AbstractC0940s.e(r11)
            r10.h()
            r10.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.w0()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6d
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            if (r0 != 0) goto L2e
            goto L82
        L2e:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            boolean r5 = r2.moveToNext()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            if (r5 == 0) goto L5c
            S1.q3 r5 = r10.f4245a     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            S1.C2 r5 = r5.a()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            S1.A2 r5 = r5.o()     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = S1.C2.x(r11)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r5.b(r6, r7)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            goto L5c
        L57:
            r0 = move-exception
            r11 = r0
            goto L68
        L5a:
            r0 = move-exception
            goto L6f
        L5c:
            if (r0 != 0) goto L5f
            goto L82
        L5f:
            S1.r r5 = new S1.r     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r5.<init>(r0, r3, r4)     // Catch: java.lang.Throwable -> L57 android.database.sqlite.SQLiteException -> L5a
            r2.close()
            return r5
        L68:
            r1 = r2
            goto L88
        L6a:
            r0 = move-exception
            r11 = r0
            goto L88
        L6d:
            r0 = move-exception
            r2 = r1
        L6f:
            S1.q3 r3 = r10.f4245a     // Catch: java.lang.Throwable -> L57
            S1.C2 r3 = r3.a()     // Catch: java.lang.Throwable -> L57
            S1.A2 r3 = r3.o()     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = S1.C2.x(r11)     // Catch: java.lang.Throwable -> L57
            r3.c(r4, r11, r0)     // Catch: java.lang.Throwable -> L57
        L82:
            if (r2 == 0) goto L87
            r2.close()
        L87:
            return r1
        L88:
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.P0(java.lang.String):S1.r");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.F Q(java.lang.String r30, java.lang.String r31, java.lang.String r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.Q(java.lang.String, java.lang.String, java.lang.String):S1.F");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Q0(com.google.android.gms.internal.measurement.zzid r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.Q0(com.google.android.gms.internal.measurement.zzid, boolean):boolean");
    }

    public final void R(String str, F f4) {
        AbstractC0940s.k(f4);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        String str2 = f4.f3927a;
        contentValues.put("app_id", str2);
        contentValues.put("name", f4.f3928b);
        contentValues.put("lifetime_count", Long.valueOf(f4.f3929c));
        contentValues.put("current_bundle_count", Long.valueOf(f4.f3930d));
        contentValues.put("last_fire_timestamp", Long.valueOf(f4.f3932f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(f4.f3933g));
        contentValues.put("last_bundled_day", f4.f3934h);
        contentValues.put("last_sampled_complex_event_id", f4.f3935i);
        contentValues.put("last_sampling_rate", f4.f3936j);
        contentValues.put("current_session_count", Long.valueOf(f4.f3931e));
        Boolean bool = f4.f3937k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (w0().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.f4245a.a().o().b("Failed to insert/update event aggregates (got -1). appId", C2.x(str2));
            }
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing event aggregates. appId", C2.x(f4.f3927a), e4);
        }
    }

    public final void S(String str, String str2) {
        AbstractC0940s.e(str2);
        h();
        j();
        try {
            w0().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error deleting snapshot. appId", C2.x(str2), e4);
        }
    }

    public final e7 T(String str, long j4, byte[] bArr, String str2, String str3, int i4, int i5, long j5, long j6, long j7) {
        if (TextUtils.isEmpty(str2)) {
            this.f4245a.a().v().a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzhz zzhzVar = (zzhz) g7.W(zzib.zzh(), bArr);
            EnumC0612k5 enumC0612k5A = EnumC0612k5.a(i4);
            if (enumC0612k5A != EnumC0612k5.GOOGLE_SIGNAL && enumC0612k5A != EnumC0612k5.GOOGLE_SIGNAL_PENDING && i5 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    zzic zzicVar = (zzic) ((zzid) it.next()).zzcl();
                    zzicVar.zzao(i5);
                    arrayList.add((zzid) zzicVar.zzbc());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length = strArrSplit.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    String str4 = strArrSplit[i6];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split(com.amazon.a.a.o.b.f.f8805b, 2);
                    if (strArrSplit2.length != 2) {
                        this.f4245a.a().o().b("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i6++;
                }
            }
            d7 d7Var = new d7();
            d7Var.b(j4);
            d7Var.c((zzib) zzhzVar.zzbc());
            d7Var.d(str2);
            d7Var.e(map);
            d7Var.f(enumC0612k5A);
            d7Var.g(j5);
            d7Var.h(j6);
            d7Var.i(j7);
            d7Var.j(i5);
            return d7Var.a();
        } catch (IOException e4) {
            this.f4245a.a().o().c("Failed to queued MeasurementBatch from upload_queue. appId", str, e4);
            return null;
        }
    }

    public final String U() {
        C0658q3 c0658q3 = this.f4245a;
        long jCurrentTimeMillis = c0658q3.f().currentTimeMillis();
        Locale locale = Locale.US;
        EnumC0612k5 enumC0612k5 = EnumC0612k5.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(enumC0612k5.zza());
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        c0658q3.w();
        Long l4 = (Long) AbstractC0569f2.f4540T.b(null);
        l4.longValue();
        String str = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, l4);
        Integer numValueOf2 = Integer.valueOf(enumC0612k5.zza());
        c0658q3.w();
        String str2 = String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", numValueOf2, lValueOf, Long.valueOf(C0622m.q()));
        StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    public final boolean W(String str, B6 b6) {
        h();
        j();
        AbstractC0940s.k(b6);
        AbstractC0940s.e(str);
        C0658q3 c0658q3 = this.f4245a;
        long jCurrentTimeMillis = c0658q3.f().currentTimeMillis();
        C0561e2 c0561e2 = AbstractC0569f2.f4610w0;
        long jLongValue = jCurrentTimeMillis - ((Long) c0561e2.b(null)).longValue();
        long j4 = b6.f3872b;
        if (j4 < jLongValue || j4 > ((Long) c0561e2.b(null)).longValue() + jCurrentTimeMillis) {
            c0658q3.a().r().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", C2.x(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j4));
        }
        c0658q3.a().w().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", b6.f3871a);
        contentValues.put("source", Integer.valueOf(b6.f3873c));
        contentValues.put("timestamp_millis", Long.valueOf(j4));
        try {
            if (w0().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            c0658q3.a().o().b("Failed to insert trigger URI (got -1). appId", C2.x(str));
            return false;
        } catch (SQLiteException e4) {
            this.f4245a.a().o().c("Error storing trigger URI. appId", C2.x(str), e4);
            return false;
        }
    }

    public final void X(String str, C0531a4 c0531a4) {
        AbstractC0940s.k(str);
        AbstractC0940s.k(c0531a4);
        h();
        j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", c0531a4.l());
        contentValues.put("consent_source", Integer.valueOf(c0531a4.b()));
        P("consent_settings", "app_id", contentValues);
    }

    public final B Y(String str) {
        AbstractC0940s.k(str);
        h();
        j();
        return B.g(O("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void Z(String str, B b4) {
        AbstractC0940s.k(str);
        AbstractC0940s.k(b4);
        h();
        j();
        C0531a4 c0531a4L = L(str);
        C0531a4 c0531a4 = C0531a4.f4335c;
        if (c0531a4L == c0531a4) {
            X(str, c0531a4);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", b4.e());
        P("consent_settings", "app_id", contentValues);
    }

    public final void a0(String str, C0531a4 c0531a4) {
        AbstractC0940s.k(str);
        AbstractC0940s.k(c0531a4);
        h();
        j();
        X(str, L(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", c0531a4.l());
        P("consent_settings", "app_id", contentValues);
    }

    public final C0531a4 b0(String str) {
        AbstractC0940s.k(str);
        h();
        j();
        return C0531a4.f(O("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x031c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x031d, code lost:
    
        r12.put("filter_id", r0);
        r21 = r3;
        r12.put("property_name", r7.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x032f, code lost:
    
        if (r7.zzg() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0331, code lost:
    
        r3 = java.lang.Boolean.valueOf(r7.zzh());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x033a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x033b, code lost:
    
        r12.put("session_scoped", r3);
        r12.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x034d, code lost:
    
        if (w0().insertWithOnConflict("property_filters", null, r12, 5) != (-1)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x034f, code lost:
    
        r22.f4245a.a().o().b("Failed to insert property filter (got -1). appId", S1.C2.x(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0363, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0365, code lost:
    
        r0 = r19;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x036b, code lost:
    
        r22.f4245a.a().o().c("Error storing property filter. appId", S1.C2.x(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x037e, code lost:
    
        j();
        h();
        com.google.android.gms.common.internal.AbstractC0940s.e(r23);
        r0 = w0();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03a1, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0494, code lost:
    
        r20.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0497, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0176, code lost:
    
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0182, code lost:
    
        if (r11.hasNext() == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x018e, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r11.next()).zza() != false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0190, code lost:
    
        r22.f4245a.a().r().c("Property filter with no ID. Audience definition ignored. appId, audienceId", S1.C2.x(r23), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a9, code lost:
    
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01b5, code lost:
    
        r19 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c3, code lost:
    
        if (r11.hasNext() == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c5, code lost:
    
        r12 = (com.google.android.gms.internal.measurement.zzff) r11.next();
        j();
        h();
        com.google.android.gms.common.internal.AbstractC0940s.e(r23);
        com.google.android.gms.common.internal.AbstractC0940s.k(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01df, code lost:
    
        if (r12.zzc().isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e1, code lost:
    
        r0 = r22.f4245a.a().r();
        r11 = S1.C2.x(r23);
        r13 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f9, code lost:
    
        if (r12.zza() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01fb, code lost:
    
        r16 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0206, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0208, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r11, r13, java.lang.String.valueOf(r16));
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0213, code lost:
    
        r3 = r12.zzcc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0217, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0219, code lost:
    
        r7 = new android.content.ContentValues();
        r7.put("app_id", r23);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x022c, code lost:
    
        if (r12.zza() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x022e, code lost:
    
        r0 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0237, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x023a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x023b, code lost:
    
        r7.put("filter_id", r0);
        r7.put("event_name", r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024b, code lost:
    
        if (r12.zzk() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x024d, code lost:
    
        r0 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0256, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0257, code lost:
    
        r7.put("session_scoped", r0);
        r7.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0269, code lost:
    
        if (w0().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x026b, code lost:
    
        r22.f4245a.a().o().b("Failed to insert event filter (got -1). appId", S1.C2.x(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x027e, code lost:
    
        r0 = r19;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0286, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0287, code lost:
    
        r22.f4245a.a().o().c("Error storing event filter. appId", S1.C2.x(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x029c, code lost:
    
        r20 = r7;
        r3 = r19.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02aa, code lost:
    
        if (r3.hasNext() == false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02ac, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.zzfn) r3.next();
        j();
        h();
        com.google.android.gms.common.internal.AbstractC0940s.e(r23);
        com.google.android.gms.common.internal.AbstractC0940s.k(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02c6, code lost:
    
        if (r7.zzc().isEmpty() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02c8, code lost:
    
        r0 = r22.f4245a.a().r();
        r9 = S1.C2.x(r23);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02e0, code lost:
    
        if (r7.zza() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02e2, code lost:
    
        r16 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ed, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ef, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02f8, code lost:
    
        r11 = r7.zzcc();
        r12 = new android.content.ContentValues();
        r12.put(r0, r23);
        r19 = r0;
        r12.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0311, code lost:
    
        if (r7.zza() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0313, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.zzb());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(java.lang.String r23, java.util.List r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.c0(java.lang.String, java.util.List):void");
    }

    public final F d0(String str, zzhs zzhsVar, String str2) throws Throwable {
        F fQ = Q("events", str, zzhsVar.zzd());
        if (fQ == null) {
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().r().c("Event aggregate wasn't created during raw event logging. appId, event", C2.x(str), c0658q3.D().a(str2));
            return new F(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j4 = fQ.f3931e + 1;
        long j5 = fQ.f3930d + 1;
        return new F(fQ.f3927a, fQ.f3928b, fQ.f3929c + 1, j5, j4, fQ.f3932f, fQ.f3933g, fQ.f3934h, fQ.f3935i, fQ.f3936j, fQ.f3937k);
    }

    public final boolean e0() {
        C0658q3 c0658q3 = this.f4245a;
        Context contextE = c0658q3.e();
        c0658q3.w();
        return contextE.getDatabasePath("google_app_measurement.db").exists();
    }

    public final /* synthetic */ long f0(String str, String[] strArr, long j4) {
        return N("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    @Override // S1.M6
    public final boolean l() {
        return false;
    }

    public final long m(String str, zzib zzibVar, String str2, Map map, EnumC0612k5 enumC0612k5, Long l4) {
        int iDelete;
        h();
        j();
        AbstractC0940s.k(zzibVar);
        AbstractC0940s.e(str);
        h();
        j();
        if (e0()) {
            b7 b7Var = this.f3955b;
            long jA = b7Var.L0().f4640f.a();
            C0658q3 c0658q3 = this.f4245a;
            long jA2 = c0658q3.f().a();
            long jAbs = Math.abs(jA2 - jA);
            c0658q3.w();
            if (jAbs > C0622m.r()) {
                b7Var.L0().f4640f.b(jA2);
                h();
                j();
                if (e0() && (iDelete = w0().delete("upload_queue", U(), new String[0])) > 0) {
                    c0658q3.a().w().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                AbstractC0940s.e(str);
                h();
                j();
                try {
                    int iE = c0658q3.w().E(str, AbstractC0569f2.f4502A);
                    if (iE > 0) {
                        w0().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iE)});
                    }
                } catch (SQLiteException e4) {
                    this.f4245a.a().o().c("Error deleting over the limit queued batches. appId", C2.x(str), e4);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append(com.amazon.a.a.o.b.f.f8805b);
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrZzcc = zzibVar.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzcc);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", AbstractC0701w.a("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(enumC0612k5.zza()));
        C0658q3 c0658q32 = this.f4245a;
        contentValues.put("creation_timestamp", Long.valueOf(c0658q32.f().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l4 != null) {
            contentValues.put("associated_row_id", l4);
        }
        try {
            long jInsert = w0().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            c0658q32.a().o().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1L;
        } catch (SQLiteException e5) {
            this.f4245a.a().o().c("Error storing MeasurementBatch to upload_queue. appId", str, e5);
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final S1.e7 n(long r19) throws java.lang.Throwable {
        /*
            r18 = this;
            r18.h()
            r18.j()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.w0()     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteException -> L91
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            java.lang.String r12 = "associated_row_id"
            java.lang.String r13 = "last_upload_timestamp"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteException -> L91
            java.lang.String r5 = "rowId=?"
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteException -> L91
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteException -> L91
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L8f android.database.sqlite.SQLiteException -> L91
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            if (r0 != 0) goto L42
            r3 = r18
            goto Lab
        L42:
            r0 = 1
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            java.lang.Object r0 = com.google.android.gms.common.internal.AbstractC0940s.k(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r0 = 9
            long r16 = r2.getLong(r0)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r3 = r18
            r5 = r19
            S1.e7 r0 = r3.T(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: java.lang.Throwable -> L84 android.database.sqlite.SQLiteException -> L86
            r2.close()
            return r0
        L84:
            r0 = move-exception
            goto L88
        L86:
            r0 = move-exception
            goto L8c
        L88:
            r3 = r18
        L8a:
            r1 = r2
            goto Lb3
        L8c:
            r3 = r18
            goto L98
        L8f:
            r0 = move-exception
            goto L93
        L91:
            r0 = move-exception
            goto L96
        L93:
            r3 = r18
            goto Lb3
        L96:
            r2 = r1
            goto L8c
        L98:
            S1.q3 r4 = r3.f4245a     // Catch: java.lang.Throwable -> Lb1
            S1.C2 r4 = r4.a()     // Catch: java.lang.Throwable -> Lb1
            S1.A2 r4 = r4.o()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r5 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r6 = java.lang.Long.valueOf(r19)     // Catch: java.lang.Throwable -> Lb1
            r4.c(r5, r6, r0)     // Catch: java.lang.Throwable -> Lb1
        Lab:
            if (r2 == 0) goto Lb0
            r2.close()
        Lb0:
            return r1
        Lb1:
            r0 = move-exception
            goto L8a
        Lb3:
            if (r1 == 0) goto Lb8
            r1.close()
        Lb8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.n(long):S1.e7");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List o(java.lang.String r19, S1.I6 r20, int r21) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.o(java.lang.String, S1.I6, int):java.util.List");
    }

    public final boolean p(String str) {
        EnumC0612k5[] enumC0612k5Arr = {EnumC0612k5.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(enumC0612k5Arr[0].zza()));
        String strV = V(arrayList);
        String strU = U();
        StringBuilder sb = new StringBuilder(String.valueOf(strV).length() + 61 + strU.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strV);
        sb.append(" AND NOT ");
        sb.append(strU);
        return M(sb.toString(), new String[]{str}) != 0;
    }

    public final void q(Long l4) {
        h();
        j();
        AbstractC0940s.k(l4);
        try {
            if (w0().delete("upload_queue", "rowid=?", new String[]{l4.toString()}) != 1) {
                this.f4245a.a().r().a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e4) {
            this.f4245a.a().o().b("Failed to delete a MeasurementBatch in a upload_queue table", e4);
            throw e4;
        }
    }

    public final /* synthetic */ A6 q0() {
        return this.f5036e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.w0()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L36
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3c
        L22:
            r0 = move-exception
            goto L3c
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            S1.q3 r3 = r6.f4245a     // Catch: java.lang.Throwable -> L1a
            S1.C2 r3 = r3.a()     // Catch: java.lang.Throwable -> L1a
            S1.A2 r3 = r3.o()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L1a
        L36:
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            return r1
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.r():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec A[Catch: all -> 0x0078, SQLiteException -> 0x007b, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0016, B:8:0x002a, B:14:0x0048, B:15:0x0064, B:18:0x006c, B:19:0x0070, B:40:0x00c8, B:42:0x00ec, B:43:0x0101, B:44:0x0105, B:45:0x0115, B:47:0x011b, B:48:0x012e, B:50:0x013a, B:53:0x014e, B:55:0x016b, B:56:0x0174, B:57:0x017e, B:62:0x01ae, B:61:0x019b, B:65:0x01b5, B:52:0x0147, B:67:0x01ca, B:71:0x01e0, B:11:0x003c, B:29:0x0087, B:31:0x008d, B:35:0x009c, B:38:0x00c0, B:32:0x0092), top: B:83:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101 A[Catch: all -> 0x0078, SQLiteException -> 0x007b, TRY_LEAVE, TryCatch #3 {all -> 0x0078, blocks: (B:3:0x0016, B:8:0x002a, B:14:0x0048, B:15:0x0064, B:18:0x006c, B:19:0x0070, B:40:0x00c8, B:42:0x00ec, B:43:0x0101, B:44:0x0105, B:45:0x0115, B:47:0x011b, B:48:0x012e, B:50:0x013a, B:53:0x014e, B:55:0x016b, B:56:0x0174, B:57:0x017e, B:62:0x01ae, B:61:0x019b, B:65:0x01b5, B:52:0x0147, B:67:0x01ca, B:71:0x01e0, B:11:0x003c, B:29:0x0087, B:31:0x008d, B:35:0x009c, B:38:0x00c0, B:32:0x0092), top: B:83:0x0016 }] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r0(java.lang.String r20, long r21, long r23, S1.X6 r25) {
        /*
            Method dump skipped, instruction units count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.r0(java.lang.String, long, long, S1.X6):void");
    }

    public final boolean s() {
        return M("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void t(long j4) {
        h();
        j();
        try {
            if (w0().delete("queue", "rowid=?", new String[]{String.valueOf(j4)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e4) {
            this.f4245a.a().o().b("Failed to delete a bundle in a queue table", e4);
            throw e4;
        }
    }

    public final void t0() {
        j();
        w0().beginTransaction();
    }

    public final void u() {
        h();
        j();
        if (e0()) {
            b7 b7Var = this.f3955b;
            long jA = b7Var.L0().f4639e.a();
            C0658q3 c0658q3 = this.f4245a;
            long jA2 = c0658q3.f().a();
            long jAbs = Math.abs(jA2 - jA);
            c0658q3.w();
            if (jAbs > C0622m.r()) {
                b7Var.L0().f4639e.b(jA2);
                h();
                j();
                if (e0()) {
                    SQLiteDatabase sQLiteDatabaseW0 = w0();
                    String strValueOf = String.valueOf(c0658q3.f().currentTimeMillis());
                    c0658q3.w();
                    int iDelete = sQLiteDatabaseW0.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(C0622m.q())});
                    if (iDelete > 0) {
                        c0658q3.a().w().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    public final void u0() {
        j();
        w0().setTransactionSuccessful();
    }

    public final void v(List list) {
        h();
        j();
        AbstractC0940s.k(list);
        AbstractC0940s.m(list.size());
        if (e0()) {
            String strJoin = TextUtils.join(com.amazon.a.a.o.b.f.f8804a, list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (M(sb2.toString(), null) > 0) {
                this.f4245a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseW0 = w0();
                StringBuilder sb3 = new StringBuilder(string.length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseW0.execSQL(sb3.toString());
            } catch (SQLiteException e4) {
                this.f4245a.a().o().b("Error incrementing retry count. error", e4);
            }
        }
    }

    public final void v0() {
        j();
        w0().endTransaction();
    }

    public final void w(Long l4) {
        h();
        j();
        AbstractC0940s.k(l4);
        if (e0()) {
            StringBuilder sb = new StringBuilder(l4.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l4);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (M(sb.toString(), null) > 0) {
                this.f4245a.a().r().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseW0 = w0();
                long jCurrentTimeMillis = this.f4245a.f().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l4.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l4);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseW0.execSQL(sb3.toString());
            } catch (SQLiteException e4) {
                this.f4245a.a().o().b("Error incrementing retry count. error", e4);
            }
        }
    }

    public final SQLiteDatabase w0() {
        h();
        try {
            return this.f5035d.getWritableDatabase();
        } catch (SQLiteException e4) {
            this.f4245a.a().r().b("Error opening database", e4);
            throw e4;
        }
    }

    public final Object x(Cursor cursor, int i4) {
        int type = cursor.getType(i4);
        if (type == 0) {
            this.f4245a.a().o().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i4));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i4));
        }
        if (type == 3) {
            return cursor.getString(i4);
        }
        if (type != 4) {
            this.f4245a.a().o().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.f4245a.a().o().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final F x0(String str, String str2) {
        return Q("events", str, str2);
    }

    public final long y() {
        return N("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final void y0(F f4) {
        R("events", f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009a A[Catch: all -> 0x0074, SQLiteException -> 0x00ae, TryCatch #0 {all -> 0x0074, blocks: (B:3:0x001b, B:6:0x0041, B:8:0x0060, B:15:0x0079, B:17:0x009a, B:20:0x00b0, B:23:0x00b8), top: B:29:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b0 A[Catch: all -> 0x0074, SQLiteException -> 0x00ae, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:3:0x001b, B:6:0x0041, B:8:0x0060, B:15:0x0079, B:17:0x009a, B:20:0x00b0, B:23:0x00b8), top: B:29:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long z(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0709x.z(java.lang.String, java.lang.String):long");
    }

    public final void z0(String str) {
        F fQ;
        S("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = w0().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (fQ = Q("events", str, string)) != null) {
                            R("events_snapshot", fQ);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e4) {
                this.f4245a.a().o().c("Error creating snapshot. appId", C2.x(str), e4);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }
}
