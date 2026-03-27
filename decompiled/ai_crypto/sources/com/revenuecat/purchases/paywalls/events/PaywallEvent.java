package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.utils.serializers.DateSerializer;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.Date;
import java.util.UUID;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.AbstractC2637y;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class PaywallEvent implements FeatureEvent {
    private final CreationData creationData;
    private final Data data;
    private final PaywallEventType type;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, AbstractC2637y.b("com.revenuecat.purchases.paywalls.events.PaywallEventType", PaywallEventType.values())};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return PaywallEvent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static final class CreationData {
        public static final Companion Companion = new Companion(null);
        private final Date date;
        private final UUID id;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return PaywallEvent$CreationData$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ CreationData(int i7, UUID uuid, Date date, k0 k0Var) {
            if (3 != (i7 & 3)) {
                AbstractC2611a0.a(i7, 3, PaywallEvent$CreationData$$serializer.INSTANCE.getDescriptor());
            }
            this.id = uuid;
            this.date = date;
        }

        public static /* synthetic */ CreationData copy$default(CreationData creationData, UUID uuid, Date date, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                uuid = creationData.id;
            }
            if ((i7 & 2) != 0) {
                date = creationData.date;
            }
            return creationData.copy(uuid, date);
        }

        public static /* synthetic */ void getDate$annotations() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        public static final /* synthetic */ void write$Self(CreationData creationData, d dVar, e eVar) {
            dVar.x(eVar, 0, UUIDSerializer.INSTANCE, creationData.id);
            dVar.x(eVar, 1, DateSerializer.INSTANCE, creationData.date);
        }

        public final UUID component1() {
            return this.id;
        }

        public final Date component2() {
            return this.date;
        }

        public final CreationData copy(UUID id, Date date) {
            r.f(id, "id");
            r.f(date, "date");
            return new CreationData(id, date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreationData)) {
                return false;
            }
            CreationData creationData = (CreationData) obj;
            return r.b(this.id, creationData.id) && r.b(this.date, creationData.date);
        }

        public final Date getDate() {
            return this.date;
        }

        public final UUID getId() {
            return this.id;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CreationData(id=" + this.id + ", date=" + this.date + ')';
        }

        public CreationData(UUID id, Date date) {
            r.f(id, "id");
            r.f(date, "date");
            this.id = id;
            this.date = date;
        }
    }

    public static final class Data {
        public static final Companion Companion = new Companion(null);
        private final boolean darkMode;
        private final String displayMode;
        private final String localeIdentifier;
        private final String offeringIdentifier;
        private final int paywallRevision;
        private final UUID sessionIdentifier;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return PaywallEvent$Data$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Data(int i7, String str, int i8, UUID uuid, String str2, String str3, boolean z7, k0 k0Var) {
            if (63 != (i7 & 63)) {
                AbstractC2611a0.a(i7, 63, PaywallEvent$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.offeringIdentifier = str;
            this.paywallRevision = i8;
            this.sessionIdentifier = uuid;
            this.displayMode = str2;
            this.localeIdentifier = str3;
            this.darkMode = z7;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, int i7, UUID uuid, String str2, String str3, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = data.offeringIdentifier;
            }
            if ((i8 & 2) != 0) {
                i7 = data.paywallRevision;
            }
            int i9 = i7;
            if ((i8 & 4) != 0) {
                uuid = data.sessionIdentifier;
            }
            UUID uuid2 = uuid;
            if ((i8 & 8) != 0) {
                str2 = data.displayMode;
            }
            String str4 = str2;
            if ((i8 & 16) != 0) {
                str3 = data.localeIdentifier;
            }
            String str5 = str3;
            if ((i8 & 32) != 0) {
                z7 = data.darkMode;
            }
            return data.copy(str, i9, uuid2, str4, str5, z7);
        }

        public static /* synthetic */ void getSessionIdentifier$annotations() {
        }

        public static final /* synthetic */ void write$Self(Data data, d dVar, e eVar) {
            dVar.m(eVar, 0, data.offeringIdentifier);
            dVar.t(eVar, 1, data.paywallRevision);
            dVar.x(eVar, 2, UUIDSerializer.INSTANCE, data.sessionIdentifier);
            dVar.m(eVar, 3, data.displayMode);
            dVar.m(eVar, 4, data.localeIdentifier);
            dVar.w(eVar, 5, data.darkMode);
        }

        public final String component1() {
            return this.offeringIdentifier;
        }

        public final int component2() {
            return this.paywallRevision;
        }

        public final UUID component3() {
            return this.sessionIdentifier;
        }

        public final String component4() {
            return this.displayMode;
        }

        public final String component5() {
            return this.localeIdentifier;
        }

        public final boolean component6() {
            return this.darkMode;
        }

        public final Data copy(String offeringIdentifier, int i7, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean z7) {
            r.f(offeringIdentifier, "offeringIdentifier");
            r.f(sessionIdentifier, "sessionIdentifier");
            r.f(displayMode, "displayMode");
            r.f(localeIdentifier, "localeIdentifier");
            return new Data(offeringIdentifier, i7, sessionIdentifier, displayMode, localeIdentifier, z7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return r.b(this.offeringIdentifier, data.offeringIdentifier) && this.paywallRevision == data.paywallRevision && r.b(this.sessionIdentifier, data.sessionIdentifier) && r.b(this.displayMode, data.displayMode) && r.b(this.localeIdentifier, data.localeIdentifier) && this.darkMode == data.darkMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getOfferingIdentifier() {
            return this.offeringIdentifier;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final UUID getSessionIdentifier() {
            return this.sessionIdentifier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        public int hashCode() {
            int iHashCode = ((((((((this.offeringIdentifier.hashCode() * 31) + Integer.hashCode(this.paywallRevision)) * 31) + this.sessionIdentifier.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31;
            boolean z7 = this.darkMode;
            ?? r12 = z7;
            if (z7) {
                r12 = 1;
            }
            return iHashCode + r12;
        }

        public String toString() {
            return "Data(offeringIdentifier=" + this.offeringIdentifier + ", paywallRevision=" + this.paywallRevision + ", sessionIdentifier=" + this.sessionIdentifier + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ')';
        }

        public Data(String offeringIdentifier, int i7, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean z7) {
            r.f(offeringIdentifier, "offeringIdentifier");
            r.f(sessionIdentifier, "sessionIdentifier");
            r.f(displayMode, "displayMode");
            r.f(localeIdentifier, "localeIdentifier");
            this.offeringIdentifier = offeringIdentifier;
            this.paywallRevision = i7;
            this.sessionIdentifier = sessionIdentifier;
            this.displayMode = displayMode;
            this.localeIdentifier = localeIdentifier;
            this.darkMode = z7;
        }
    }

    public /* synthetic */ PaywallEvent(int i7, CreationData creationData, Data data, PaywallEventType paywallEventType, k0 k0Var) {
        if (7 != (i7 & 7)) {
            AbstractC2611a0.a(i7, 7, PaywallEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.creationData = creationData;
        this.data = data;
        this.type = paywallEventType;
    }

    public static /* synthetic */ PaywallEvent copy$default(PaywallEvent paywallEvent, CreationData creationData, Data data, PaywallEventType paywallEventType, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            creationData = paywallEvent.creationData;
        }
        if ((i7 & 2) != 0) {
            data = paywallEvent.data;
        }
        if ((i7 & 4) != 0) {
            paywallEventType = paywallEvent.type;
        }
        return paywallEvent.copy(creationData, data, paywallEventType);
    }

    public static final /* synthetic */ void write$Self(PaywallEvent paywallEvent, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.x(eVar, 0, PaywallEvent$CreationData$$serializer.INSTANCE, paywallEvent.creationData);
        dVar.x(eVar, 1, PaywallEvent$Data$$serializer.INSTANCE, paywallEvent.data);
        dVar.x(eVar, 2, bVarArr[2], paywallEvent.type);
    }

    public final CreationData component1() {
        return this.creationData;
    }

    public final Data component2() {
        return this.data;
    }

    public final PaywallEventType component3() {
        return this.type;
    }

    public final PaywallEvent copy(CreationData creationData, Data data, PaywallEventType type) {
        r.f(creationData, "creationData");
        r.f(data, "data");
        r.f(type, "type");
        return new PaywallEvent(creationData, data, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallEvent)) {
            return false;
        }
        PaywallEvent paywallEvent = (PaywallEvent) obj;
        return r.b(this.creationData, paywallEvent.creationData) && r.b(this.data, paywallEvent.data) && this.type == paywallEvent.type;
    }

    public final CreationData getCreationData() {
        return this.creationData;
    }

    public final Data getData() {
        return this.data;
    }

    public final PaywallEventType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.creationData.hashCode() * 31) + this.data.hashCode()) * 31) + this.type.hashCode();
    }

    public final PaywallPostReceiptData toPaywallPostReceiptData$purchases_defaultsRelease() {
        String string = this.data.getSessionIdentifier().toString();
        r.e(string, "data.sessionIdentifier.toString()");
        return new PaywallPostReceiptData(string, this.data.getPaywallRevision(), this.data.getDisplayMode(), this.data.getDarkMode(), this.data.getLocaleIdentifier(), this.data.getOfferingIdentifier());
    }

    public String toString() {
        return "PaywallEvent(creationData=" + this.creationData + ", data=" + this.data + ", type=" + this.type + ')';
    }

    public PaywallEvent(CreationData creationData, Data data, PaywallEventType type) {
        r.f(creationData, "creationData");
        r.f(data, "data");
        r.f(type, "type");
        this.creationData = creationData;
        this.data = data;
        this.type = type;
    }
}
