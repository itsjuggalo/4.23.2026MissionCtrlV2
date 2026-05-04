package b7;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f2996g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateFormat f2997h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f3001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3003f;

    public b(String str, String str2, String str3, Date date, long j10, long j11) {
        this.f2998a = str;
        this.f2999b = str2;
        this.f3000c = str3;
        this.f3001d = date;
        this.f3002e = j10;
        this.f3003f = j11;
    }

    public static b a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str = conditionalUserProperty.triggerEventName;
        if (str == null) {
            str = "";
        }
        return new b(conditionalUserProperty.name, String.valueOf(conditionalUserProperty.value), str, new Date(conditionalUserProperty.creationTimestamp), conditionalUserProperty.triggerTimeout, conditionalUserProperty.timeToLive);
    }

    public static b b(Map map) throws a {
        i(map);
        try {
            return new b((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey("triggerEvent") ? (String) map.get("triggerEvent") : "", f2997h.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
        } catch (NumberFormatException e10) {
            throw new a("Could not process experiment: one of the durations could not be converted into a long.", e10);
        } catch (ParseException e11) {
            throw new a("Could not process experiment: parsing experiment start time failed.", e11);
        }
    }

    public static void h(b bVar) throws a {
        i(bVar.g());
    }

    public static void i(Map map) throws a {
        ArrayList arrayList = new ArrayList();
        for (String str : f2996g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new a(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    public String c() {
        return this.f2998a;
    }

    public long d() {
        return this.f3001d.getTime();
    }

    public String e() {
        return this.f2999b;
    }

    public AnalyticsConnector.ConditionalUserProperty f(String str) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = str;
        conditionalUserProperty.creationTimestamp = d();
        conditionalUserProperty.name = this.f2998a;
        conditionalUserProperty.value = this.f2999b;
        conditionalUserProperty.triggerEventName = TextUtils.isEmpty(this.f3000c) ? null : this.f3000c;
        conditionalUserProperty.triggerTimeout = this.f3002e;
        conditionalUserProperty.timeToLive = this.f3003f;
        return conditionalUserProperty;
    }

    public Map g() {
        HashMap map = new HashMap();
        map.put("experimentId", this.f2998a);
        map.put("variantId", this.f2999b);
        map.put("triggerEvent", this.f3000c);
        map.put("experimentStartTime", f2997h.format(this.f3001d));
        map.put("triggerTimeoutMillis", Long.toString(this.f3002e));
        map.put("timeToLiveMillis", Long.toString(this.f3003f));
        return map;
    }
}
