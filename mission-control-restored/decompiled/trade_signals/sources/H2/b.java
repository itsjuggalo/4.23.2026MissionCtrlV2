package H2;

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

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f3649g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateFormat f3650h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f3654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3656f;

    public b(String str, String str2, String str3, Date date, long j8, long j9) {
        this.f3651a = str;
        this.f3652b = str2;
        this.f3653c = str3;
        this.f3654d = date;
        this.f3655e = j8;
        this.f3656f = j9;
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
            return new b((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey("triggerEvent") ? (String) map.get("triggerEvent") : "", f3650h.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
        } catch (NumberFormatException e8) {
            throw new a("Could not process experiment: one of the durations could not be converted into a long.", e8);
        } catch (ParseException e9) {
            throw new a("Could not process experiment: parsing experiment start time failed.", e9);
        }
    }

    public static void h(b bVar) throws a {
        i(bVar.g());
    }

    public static void i(Map map) throws a {
        ArrayList arrayList = new ArrayList();
        for (String str : f3649g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new a(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    public String c() {
        return this.f3651a;
    }

    public long d() {
        return this.f3654d.getTime();
    }

    public String e() {
        return this.f3652b;
    }

    public AnalyticsConnector.ConditionalUserProperty f(String str) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = str;
        conditionalUserProperty.creationTimestamp = d();
        conditionalUserProperty.name = this.f3651a;
        conditionalUserProperty.value = this.f3652b;
        conditionalUserProperty.triggerEventName = TextUtils.isEmpty(this.f3653c) ? null : this.f3653c;
        conditionalUserProperty.triggerTimeout = this.f3655e;
        conditionalUserProperty.timeToLive = this.f3656f;
        return conditionalUserProperty;
    }

    public Map g() {
        HashMap map = new HashMap();
        map.put("experimentId", this.f3651a);
        map.put("variantId", this.f3652b);
        map.put("triggerEvent", this.f3653c);
        map.put("experimentStartTime", f3650h.format(this.f3654d));
        map.put("triggerTimeoutMillis", Long.toString(this.f3655e));
        map.put("timeToLiveMillis", Long.toString(this.f3656f));
        return map;
    }
}
