package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.utils.Event;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsEntry implements Event {

    @Deprecated
    public static final String APP_SESSION_ID_KEY = "app_session_id";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ID_KEY = "id";

    @Deprecated
    public static final String NAME_KEY = "name";

    @Deprecated
    public static final String PROPERTIES_KEY = "properties";

    @Deprecated
    public static final String TIMESTAMP_KEY = "timestamp";

    @Deprecated
    public static final int VERSION = 1;

    @Deprecated
    public static final String VERSION_KEY = "version";
    private final UUID appSessionID;
    private final DateProvider dateProvider;
    private final Date dateTime;
    private final UUID id;
    private final DiagnosticsEntryName name;
    private final Map<String, Object> properties;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public DiagnosticsEntry(UUID id, DiagnosticsEntryName name, Map<String, ? extends Object> properties, UUID appSessionID, DateProvider dateProvider, Date dateTime) {
        r.f(id, "id");
        r.f(name, "name");
        r.f(properties, "properties");
        r.f(appSessionID, "appSessionID");
        r.f(dateProvider, "dateProvider");
        r.f(dateTime, "dateTime");
        this.id = id;
        this.name = name;
        this.properties = properties;
        this.appSessionID = appSessionID;
        this.dateProvider = dateProvider;
        this.dateTime = dateTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiagnosticsEntry copy$default(DiagnosticsEntry diagnosticsEntry, UUID uuid, DiagnosticsEntryName diagnosticsEntryName, Map map, UUID uuid2, DateProvider dateProvider, Date date, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            uuid = diagnosticsEntry.id;
        }
        if ((i4 & 2) != 0) {
            diagnosticsEntryName = diagnosticsEntry.name;
        }
        if ((i4 & 4) != 0) {
            map = diagnosticsEntry.properties;
        }
        if ((i4 & 8) != 0) {
            uuid2 = diagnosticsEntry.appSessionID;
        }
        if ((i4 & 16) != 0) {
            dateProvider = diagnosticsEntry.dateProvider;
        }
        if ((i4 & 32) != 0) {
            date = diagnosticsEntry.dateTime;
        }
        DateProvider dateProvider2 = dateProvider;
        Date date2 = date;
        return diagnosticsEntry.copy(uuid, diagnosticsEntryName, map, uuid2, dateProvider2, date2);
    }

    private final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ID_KEY, this.id);
        jSONObject.put(VERSION_KEY, 1);
        String lowerCase = this.name.name().toLowerCase(Locale.ROOT);
        r.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        jSONObject.put("name", lowerCase);
        jSONObject.put(PROPERTIES_KEY, new JSONObject(this.properties));
        jSONObject.put(APP_SESSION_ID_KEY, this.appSessionID);
        jSONObject.put("timestamp", Iso8601Utils.format(this.dateTime));
        return jSONObject;
    }

    public final UUID component1() {
        return this.id;
    }

    public final DiagnosticsEntryName component2() {
        return this.name;
    }

    public final Map<String, Object> component3() {
        return this.properties;
    }

    public final UUID component4() {
        return this.appSessionID;
    }

    public final DateProvider component5() {
        return this.dateProvider;
    }

    public final Date component6() {
        return this.dateTime;
    }

    public final DiagnosticsEntry copy(UUID id, DiagnosticsEntryName name, Map<String, ? extends Object> properties, UUID appSessionID, DateProvider dateProvider, Date dateTime) {
        r.f(id, "id");
        r.f(name, "name");
        r.f(properties, "properties");
        r.f(appSessionID, "appSessionID");
        r.f(dateProvider, "dateProvider");
        r.f(dateTime, "dateTime");
        return new DiagnosticsEntry(id, name, properties, appSessionID, dateProvider, dateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiagnosticsEntry)) {
            return false;
        }
        DiagnosticsEntry diagnosticsEntry = (DiagnosticsEntry) obj;
        return r.b(this.id, diagnosticsEntry.id) && this.name == diagnosticsEntry.name && r.b(this.properties, diagnosticsEntry.properties) && r.b(this.appSessionID, diagnosticsEntry.appSessionID) && r.b(this.dateProvider, diagnosticsEntry.dateProvider) && r.b(this.dateTime, diagnosticsEntry.dateTime);
    }

    public final UUID getAppSessionID() {
        return this.appSessionID;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final Date getDateTime() {
        return this.dateTime;
    }

    public final UUID getId() {
        return this.id;
    }

    public final DiagnosticsEntryName getName() {
        return this.name;
    }

    public final Map<String, Object> getProperties() {
        return this.properties;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.properties.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + this.dateProvider.hashCode()) * 31) + this.dateTime.hashCode();
    }

    @Override // com.revenuecat.purchases.utils.Event
    public String toString() {
        String string = toJSONObject().toString();
        r.e(string, "toJSONObject().toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DiagnosticsEntry(UUID uuid, DiagnosticsEntryName diagnosticsEntryName, Map map, UUID uuid2, DateProvider dateProvider, Date date, int i4, AbstractC1585j abstractC1585j) {
        if ((i4 & 1) != 0) {
            uuid = UUID.randomUUID();
            r.e(uuid, "randomUUID()");
        }
        UUID uuid3 = uuid;
        DateProvider defaultDateProvider = (i4 & 16) != 0 ? new DefaultDateProvider() : dateProvider;
        this(uuid3, diagnosticsEntryName, map, uuid2, defaultDateProvider, (i4 & 32) != 0 ? defaultDateProvider.getNow() : date);
    }
}
