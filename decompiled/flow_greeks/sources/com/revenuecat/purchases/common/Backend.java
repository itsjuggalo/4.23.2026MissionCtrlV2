package com.revenuecat.purchases.common;

import cd.h0;
import cd.q;
import cd.w;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.PostReceiptResponseKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.customercenter.CustomerCenterRoot;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import dd.a0;
import dd.n0;
import dd.o0;
import dd.r;
import dd.s;
import eh.u;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pd.k;
import pd.o;
import pd.p;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ¸\u00012\u00020\u0001:\u0002¸\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013Js\u0010!\u001a\u00020 \"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015* \u0012\u0004\u0012\u00020\u0017\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00190\u00180\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00172\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J[\u0010%\u001a\u00020 \"\u0004\b\u0000\u0010#\"\u0004\b\u0001\u0010$*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020 ¢\u0006\u0004\b'\u0010(JK\u00102\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020 0-2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 00¢\u0006\u0004\b2\u00103J½\u0001\u0010F\u001a\u00020 2\u0006\u00104\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2 \u00108\u001a\u001c\u0012\u0004\u0012\u00020)\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010\u000107072\u0006\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010)2\u0006\u0010>\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010?2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020 0-j\u0002`B2$\u00101\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010D\u0012\u0004\u0012\u00020 0Cj\u0002`E¢\u0006\u0004\bF\u0010GJQ\u0010J\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 002\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020 00¢\u0006\u0004\bJ\u0010KJK\u0010O\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010L\u001a\u00020)2\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 002\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bO\u0010PJ?\u0010S\u001a\u00020 2\u0006\u0010Q\u001a\u00020)2\u0006\u0010L\u001a\u00020)2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020 0R2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bS\u0010TJI\u0010W\u001a\u00020 2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020D0U2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020 0-2\u0018\u0010N\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 00¢\u0006\u0004\bW\u0010XJM\u0010]\u001a\u00020 2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020 0R2\u0018\u0010N\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 00¢\u0006\u0004\b]\u0010^J5\u0010`\u001a\u00020 2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020 0-2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\b`\u0010aJ=\u0010c\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020 0-2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bc\u0010dJM\u0010g\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020)2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0-2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bg\u0010hJ1\u0010l\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010i\u001a\u00020)2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bl\u0010mJE\u0010o\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020 0-2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bo\u0010pJK\u0010t\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020)0q2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020 0-2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-¢\u0006\u0004\bt\u0010uJ\r\u0010v\u001a\u00020 ¢\u0006\u0004\bv\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010wR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010xR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010xR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010yR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010zR\u00ad\u0001\u0010}\u001aB\u0012\u0004\u0012\u00020\u0017\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020 0-\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0002`{0\u00180\u00162F\u0010|\u001aB\u0012\u0004\u0012\u00020\u0017\u00128\u00126\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020 0-\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0002`{0\u00180\u00168F@FX\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001Rè\u0001\u0010\u0085\u0001\u001a^\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u0012I\u0012G\u0012C\u0012A\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020 0-j\u0002`B\u0012\"\u0012 \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010D\u0012\u0004\u0012\u00020 0Cj\u0002`E0\u0019j\u0003`\u0084\u00010\u00180\u00162b\u0010|\u001a^\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u0012I\u0012G\u0012C\u0012A\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020 0-j\u0002`B\u0012\"\u0012 \u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010D\u0012\u0004\u0012\u00020 0Cj\u0002`E0\u0019j\u0003`\u0084\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0085\u0001\u0010~\u001a\u0006\b\u0086\u0001\u0010\u0080\u0001\"\u0006\b\u0087\u0001\u0010\u0082\u0001R¾\u0001\u0010\u0089\u0001\u001aI\u0012\u0004\u0012\u00020\u0017\u0012?\u0012=\u00129\u00127\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 00\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0088\u00010\u00180\u00162M\u0010|\u001aI\u0012\u0004\u0012\u00020\u0017\u0012?\u0012=\u00129\u00127\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020 00\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0088\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0089\u0001\u0010~\u001a\u0006\b\u008a\u0001\u0010\u0080\u0001\"\u0006\b\u008b\u0001\u0010\u0082\u0001RÈ\u0001\u0010\u008d\u0001\u001aN\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00129\u00127\u00123\u00121\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 00\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u008c\u00010\u00180\u00162R\u0010|\u001aN\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00129\u00127\u00123\u00121\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 00\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u008c\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u008d\u0001\u0010~\u001a\u0006\b\u008e\u0001\u0010\u0080\u0001\"\u0006\b\u008f\u0001\u0010\u0082\u0001R°\u0001\u0010\u0091\u0001\u001aB\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u0012-\u0012+\u0012'\u0012%\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0R\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u0090\u00010\u00180\u00162F\u0010|\u001aB\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u0012-\u0012+\u0012'\u0012%\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0R\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u0090\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0091\u0001\u0010~\u001a\u0006\b\u0092\u0001\u0010\u0080\u0001\"\u0006\b\u0093\u0001\u0010\u0082\u0001RÈ\u0001\u0010\u0095\u0001\u001aN\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00129\u00127\u00123\u00121\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020 0-\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0094\u00010\u00180\u00162R\u0010|\u001aN\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00129\u00127\u00123\u00121\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020 0-\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0094\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0095\u0001\u0010~\u001a\u0006\b\u0096\u0001\u0010\u0080\u0001\"\u0006\b\u0097\u0001\u0010\u0082\u0001R¼\u0001\u0010\u0099\u0001\u001aH\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00123\u00121\u0012-\u0012+\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0R\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0098\u00010\u00180\u00162L\u0010|\u001aH\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020)0Uj\u0003`\u0083\u0001\u00123\u00121\u0012-\u0012+\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0R\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 000\u0019j\u0003`\u0098\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u0099\u0001\u0010~\u001a\u0006\b\u009a\u0001\u0010\u0080\u0001\"\u0006\b\u009b\u0001\u0010\u0082\u0001R¦\u0001\u0010\u009d\u0001\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u009c\u00010\u00180\u00162A\u0010|\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`\u009c\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u009d\u0001\u0010~\u001a\u0006\b\u009e\u0001\u0010\u0080\u0001\"\u0006\b\u009f\u0001\u0010\u0082\u0001R¦\u0001\u0010¡\u0001\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003` \u00010\u00180\u00162A\u0010|\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003` \u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b¡\u0001\u0010~\u001a\u0006\b¢\u0001\u0010\u0080\u0001\"\u0006\b£\u0001\u0010\u0082\u0001R¦\u0001\u0010¥\u0001\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`¤\u00010\u00180\u00162A\u0010|\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`¤\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b¥\u0001\u0010~\u001a\u0006\b¦\u0001\u0010\u0080\u0001\"\u0006\b§\u0001\u0010\u0082\u0001Rv\u0010©\u0001\u001a%\u0012\u0004\u0012\u00020)\u0012\u001b\u0012\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020 0-j\u0003`¨\u00010\u00180\u00162)\u0010|\u001a%\u0012\u0004\u0012\u00020)\u0012\u001b\u0012\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020 0-j\u0003`¨\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b©\u0001\u0010~\u001a\u0006\bª\u0001\u0010\u0080\u0001\"\u0006\b«\u0001\u0010\u0082\u0001R¦\u0001\u0010\u00ad\u0001\u001a=\u0012\u0004\u0012\u00020\u0017\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`¬\u00010\u00180\u00162A\u0010|\u001a=\u0012\u0004\u0012\u00020\u0017\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`¬\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b\u00ad\u0001\u0010~\u001a\u0006\b®\u0001\u0010\u0080\u0001\"\u0006\b¯\u0001\u0010\u0082\u0001R¦\u0001\u0010±\u0001\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`°\u00010\u00180\u00162A\u0010|\u001a=\u0012\u0004\u0012\u00020)\u00123\u00121\u0012-\u0012+\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020 0-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0-0\u0019j\u0003`°\u00010\u00180\u00168F@FX\u0086\u000e¢\u0006\u0017\n\u0005\b±\u0001\u0010~\u001a\u0006\b²\u0001\u0010\u0080\u0001\"\u0006\b³\u0001\u0010\u0082\u0001R\u0015\u0010·\u0001\u001a\u00030´\u00018F¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001¨\u0006¹\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/Backend;", "", "Lcom/revenuecat/purchases/common/AppConfig;", "appConfig", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "eventsDispatcher", "Lcom/revenuecat/purchases/common/HTTPClient;", "httpClient", "Lcom/revenuecat/purchases/common/BackendHelper;", "backendHelper", "<init>", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/HTTPClient;Lcom/revenuecat/purchases/common/BackendHelper;)V", "", "responseCode", "Lcom/revenuecat/purchases/PurchasesError;", "purchasesError", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "determinePostReceiptErrorHandlingBehavior", "(ILcom/revenuecat/purchases/PurchasesError;)Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "S", "E", "", "Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;", "", "Lcd/q;", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "cacheKey", "functions", "Lcom/revenuecat/purchases/common/Delay;", "delay", "Lcd/h0;", "addBackgroundAwareCallback", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/common/BackgroundAwareCallbackCacheKey;Lcd/q;Lcom/revenuecat/purchases/common/Delay;)V", "K", "F", "addCallback", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/lang/Object;Ljava/lang/Object;Lcom/revenuecat/purchases/common/Delay;)V", "close", "()V", "", "appUserID", "", "appInBackground", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onSuccess", "Lkotlin/Function2;", "onError", "getCustomerInfo", "(Ljava/lang/String;ZLpd/k;Lpd/o;)V", "purchaseToken", "isRestore", "finishTransactions", "", "subscriberAttributes", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "receiptInfo", "storeAppUserID", com.amazon.a.a.o.b.f4559m, "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "initiationSource", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lkotlin/Function3;", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "postReceiptData", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/revenuecat/purchases/common/ReceiptInfo;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PostReceiptInitiationSource;Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;Lpd/k;Lpd/p;)V", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "Lcom/revenuecat/purchases/common/GetOfferingsErrorHandlingBehavior;", "getOfferings", "(Ljava/lang/String;ZLpd/o;Lpd/o;)V", "newAppUserID", "onSuccessHandler", "onErrorHandler", "logIn", "(Ljava/lang/String;Ljava/lang/String;Lpd/o;Lpd/k;)V", "oldAppUserID", "Lkotlin/Function0;", "aliasUsers", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lpd/k;)V", "", "diagnosticsList", "postDiagnostics", "(Ljava/util/List;Lpd/k;Lpd/o;)V", "Lcom/revenuecat/purchases/common/events/EventsRequest;", "paywallEventRequest", "Ljava/net/URL;", "baseURL", "postEvents", "(Lcom/revenuecat/purchases/common/events/EventsRequest;Ljava/net/URL;Lcom/revenuecat/purchases/common/Delay;Lkotlin/jvm/functions/Function0;Lpd/o;)V", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "getProductEntitlementMapping", "(Lpd/k;Lpd/k;)V", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "getCustomerCenterConfig", "(Ljava/lang/String;Lpd/k;Lpd/k;)V", io.flutter.plugins.firebase.auth.Constants.EMAIL, com.amazon.a.a.o.b.f4549c, "postCreateSupportTicket", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpd/k;Lpd/k;)V", "redemptionToken", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "onResultHandler", "postRedeemWebPurchase", "(Ljava/lang/String;Ljava/lang/String;Lpd/k;)V", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getVirtualCurrencies", "(Ljava/lang/String;ZLpd/k;Lpd/k;)V", "", "productIds", "Lcom/revenuecat/purchases/common/networking/WebBillingProductsResponse;", "getWebBillingProducts", "(Ljava/lang/String;Ljava/util/Set;Lpd/k;Lpd/k;)V", "clearCaches", "Lcom/revenuecat/purchases/common/AppConfig;", "Lcom/revenuecat/purchases/common/Dispatcher;", "Lcom/revenuecat/purchases/common/HTTPClient;", "Lcom/revenuecat/purchases/common/BackendHelper;", "Lcom/revenuecat/purchases/common/CustomerInfoCallback;", "<set-?>", "callbacks", "Ljava/util/Map;", "getCallbacks", "()Ljava/util/Map;", "setCallbacks", "(Ljava/util/Map;)V", "Lcom/revenuecat/purchases/common/CallbackCacheKey;", "Lcom/revenuecat/purchases/common/PostReceiptCallback;", "postReceiptCallbacks", "getPostReceiptCallbacks", "setPostReceiptCallbacks", "Lcom/revenuecat/purchases/common/OfferingsCallback;", "offeringsCallbacks", "getOfferingsCallbacks", "setOfferingsCallbacks", "Lcom/revenuecat/purchases/common/IdentifyCallback;", "identifyCallbacks", "getIdentifyCallbacks", "setIdentifyCallbacks", "Lcom/revenuecat/purchases/common/AliasCallback;", "aliasCallbacks", "getAliasCallbacks", "setAliasCallbacks", "Lcom/revenuecat/purchases/common/DiagnosticsCallback;", "diagnosticsCallbacks", "getDiagnosticsCallbacks", "setDiagnosticsCallbacks", "Lcom/revenuecat/purchases/common/PaywallEventsCallback;", "paywallEventsCallbacks", "getPaywallEventsCallbacks", "setPaywallEventsCallbacks", "Lcom/revenuecat/purchases/common/ProductEntitlementCallback;", "productEntitlementCallbacks", "getProductEntitlementCallbacks", "setProductEntitlementCallbacks", "Lcom/revenuecat/purchases/common/CustomerCenterCallback;", "customerCenterCallbacks", "getCustomerCenterCallbacks", "setCustomerCenterCallbacks", "Lcom/revenuecat/purchases/common/CreateSupportTicketCallback;", "createSupportTicketCallbacks", "getCreateSupportTicketCallbacks", "setCreateSupportTicketCallbacks", "Lcom/revenuecat/purchases/common/RedeemWebPurchaseCallback;", "redeemWebPurchaseCallbacks", "getRedeemWebPurchaseCallbacks", "setRedeemWebPurchaseCallbacks", "Lcom/revenuecat/purchases/common/VirtualCurrenciesCallback;", "virtualCurrenciesCallbacks", "getVirtualCurrenciesCallbacks", "setVirtualCurrenciesCallbacks", "Lcom/revenuecat/purchases/common/WebBillingProductsCallback;", "webBillingProductsCallbacks", "getWebBillingProductsCallbacks", "setWebBillingProductsCallbacks", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "getVerificationMode", "()Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "verificationMode", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Backend {
    private static final String APP_USER_ID = "app_user_id";
    private static final String FETCH_TOKEN = "fetch_token";
    private static final String NEW_APP_USER_ID = "new_app_user_id";
    private volatile Map<List<String>, List<q>> aliasCallbacks;
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<q>> callbacks;
    private volatile Map<String, List<q>> createSupportTicketCallbacks;
    private volatile Map<String, List<q>> customerCenterCallbacks;
    private volatile Map<List<String>, List<q>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<q>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<q>> offeringsCallbacks;
    private volatile Map<List<String>, List<q>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<q>> postReceiptCallbacks;
    private volatile Map<String, List<q>> productEntitlementCallbacks;
    private volatile Map<String, List<k>> redeemWebPurchaseCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<q>> virtualCurrenciesCallbacks;
    private volatile Map<String, List<q>> webBillingProductsCallbacks;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final eh.b json = u.b(null, Backend$Companion$json$1.INSTANCE, 1, null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/Backend$Companion;", "", "<init>", "()V", "Leh/b;", "json", "Leh/b;", "getJson$purchases_defaultsBc8Release", "()Leh/b;", "getJson$purchases_defaultsBc8Release$annotations", "", "APP_USER_ID", "Ljava/lang/String;", "FETCH_TOKEN", "NEW_APP_USER_ID", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final eh.b getJson$purchases_defaultsBc8Release() {
            return Backend.json;
        }

        private Companion() {
        }

        public static /* synthetic */ void getJson$purchases_defaultsBc8Release$annotations() {
        }
    }

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper) {
        t.f(appConfig, "appConfig");
        t.f(dispatcher, "dispatcher");
        t.f(eventsDispatcher, "eventsDispatcher");
        t.f(httpClient, "httpClient");
        t.f(backendHelper, "backendHelper");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.aliasCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
        this.customerCenterCallbacks = new LinkedHashMap();
        this.createSupportTicketCallbacks = new LinkedHashMap();
        this.redeemWebPurchaseCallbacks = new LinkedHashMap();
        this.virtualCurrenciesCallbacks = new LinkedHashMap();
        this.webBillingProductsCallbacks = new LinkedHashMap();
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<q>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, q qVar, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        try {
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
            boolean zContainsKey = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    String str = "[Purchases] - " + logLevel.name();
                    String str2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    t.e(str2, "format(...)");
                    currentLogHandler.d(str, str2);
                }
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKeyCopy$default;
            } else {
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
            }
            addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, qVar, delay);
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
            boolean zContainsKey2 = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (!backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey2) {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    String str3 = "[Purchases] - " + logLevel2.name();
                    String str4 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    t.e(str4, "format(...)");
                    currentLogHandler2.d(str3, str4);
                }
                List<q> listRemove = map.remove(backgroundAwareCallbackCacheKeyCopy$default2);
                if (listRemove != null) {
                    List<q> list = listRemove.isEmpty() ? null : listRemove;
                    if (list != null) {
                        if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                            List<q> list2 = map.get(backgroundAwareCallbackCacheKey);
                            if (list2 != null) {
                                list2.addAll(list);
                            }
                        } else {
                            map.put(backgroundAwareCallbackCacheKey, list);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, q qVar, Delay delay, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, qVar, delay);
    }

    private final <K, F> void addCallback(Map<K, List<F>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k10, F f10, Delay delay) {
        if (!map.containsKey(k10)) {
            map.put(k10, r.q(f10));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            s0 s0Var = s0.f14953a;
            String str2 = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k10}, 1));
            t.e(str2, "format(...)");
            currentLogHandler.d(str, str2);
        }
        List<F> list = map.get(k10);
        t.c(list);
        list.add(f10);
    }

    public static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Object obj2, Delay delay, int i10, Object obj3) {
        if ((i10 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, obj2, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int responseCode, PurchasesError purchasesError) {
        return RCHTTPStatusCodes.INSTANCE.isServerError(responseCode) ? PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME : purchasesError.getCode() == PurchasesErrorCode.UnsupportedError ? PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME : PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED;
    }

    public final void aliasUsers(final String oldAppUserID, final String newAppUserID, Function0 onSuccessHandler, k onErrorHandler) {
        t.f(oldAppUserID, "oldAppUserID");
        t.f(newAppUserID, "newAppUserID");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final List listP = r.p(oldAppUserID, newAppUserID);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$aliasUsers$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), new Endpoint.AliasUsers(oldAppUserID), o0.l(w.a("app_user_id", oldAppUserID), w.a("new_app_user_id", newAppUserID)), null, this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function0) ((q) it.next()).a()).invoke();
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.aliasCallbacks, asyncCall, this.dispatcher, listP, w.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final synchronized Map<List<String>, List<q>> getAliasCallbacks() {
        return this.aliasCallbacks;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<q>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized Map<String, List<q>> getCreateSupportTicketCallbacks() {
        return this.createSupportTicketCallbacks;
    }

    public final synchronized Map<String, List<q>> getCustomerCenterCallbacks() {
        return this.customerCenterCallbacks;
    }

    public final void getCustomerCenterConfig(String appUserID, k onSuccessHandler, k onErrorHandler) {
        t.f(appUserID, "appUserID");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final Endpoint.GetCustomerCenterConfig getCustomerCenterConfig = new Endpoint.GetCustomerCenterConfig(appUserID);
        final String path$default = Endpoint.getPath$default(getCustomerCenterConfig, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerCenterConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerCenterConfig, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        k kVar2 = (k) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                eh.b json$purchases_defaultsBc8Release = Backend.INSTANCE.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.a();
                                kVar.invoke(((CustomerCenterRoot) json$purchases_defaultsBc8Release.d(CustomerCenterRoot.INSTANCE.serializer(), payload)).getCustomerCenter());
                            } catch (j e10) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e11) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e11);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            kVar2.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.customerCenterCallbacks, asyncCall, this.dispatcher, path$default, w.a(onSuccessHandler, onErrorHandler), Delay.NONE);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getCustomerInfo(String appUserID, boolean appInBackground, k onSuccess, o onError) {
        Throwable th;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        Throwable th2;
        Delay delay;
        t.f(appUserID, "appUserID");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path$default = Endpoint.getPath$default(getCustomerInfo, false, 1, null);
        synchronized (this) {
            try {
                if (this.postReceiptCallbacks.isEmpty()) {
                    try {
                        backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(dd.q.e(path$default), appInBackground);
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(a0.t0(dd.q.e(path$default), String.valueOf(this.callbacks.size())), appInBackground);
                }
                final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public HTTPResult call() {
                        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerInfo, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onCompletion(HTTPResult result) {
                        List<q> listRemove;
                        t.f(result, "result");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            for (q qVar : listRemove) {
                                k kVar = (k) qVar.a();
                                o oVar = (o) qVar.b();
                                try {
                                    if (BackendHelperKt.isSuccessful(result)) {
                                        kVar.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                                    } else {
                                        PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                        LogUtilsKt.errorLog(purchasesError);
                                        oVar.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                                    }
                                } catch (JSONException e10) {
                                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e10);
                                    LogUtilsKt.errorLog(purchasesError2);
                                    oVar.invoke(purchasesError2, Boolean.FALSE);
                                }
                            }
                        }
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onError(PurchasesError error) {
                        List<q> listRemove;
                        t.f(error, "error");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((o) ((q) it.next()).b()).invoke(error, Boolean.FALSE);
                            }
                        }
                    }
                };
                synchronized (this) {
                    if (appInBackground) {
                        try {
                            delay = Delay.DEFAULT;
                        } catch (Throwable th4) {
                            th2 = th4;
                            throw th2;
                        }
                    } else {
                        try {
                            delay = Delay.NONE;
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            throw th2;
                        }
                    }
                    try {
                        addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, w.a(onSuccess, onError), delay);
                        h0 h0Var = h0.f3852a;
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public final synchronized Map<List<String>, List<q>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized Map<List<String>, List<q>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final void getOfferings(String appUserID, boolean appInBackground, o onSuccess, o onError) {
        Delay delay;
        Throwable th;
        t.f(appUserID, "appUserID");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(dd.q.e(Endpoint.getPath$default(getOfferings, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getOfferings, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        o oVar = (o) qVar.a();
                        o oVar2 = (o) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                oVar.invoke(result.getBody(), HTTPResponseOriginalSourceKt.getOriginalDataSource(result));
                            } catch (JSONException e10) {
                                GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior = GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS;
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                oVar2.invoke(purchasesError, getOfferingsErrorHandlingBehavior);
                            }
                        } else {
                            GetOfferingsErrorHandlingBehavior getOfferingsErrorHandlingBehavior2 = RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) ? GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS : GetOfferingsErrorHandlingBehavior.SHOULD_NOT_FALLBACK;
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            oVar2.invoke(purchasesError2, getOfferingsErrorHandlingBehavior2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((o) ((q) it.next()).b()).invoke(error, GetOfferingsErrorHandlingBehavior.SHOULD_FALLBACK_TO_CACHED_OFFERINGS);
                    }
                }
            }
        };
        synchronized (this) {
            if (appInBackground) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, w.a(onSuccess, onError), delay);
                h0 h0Var = h0.f3852a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<q>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized Map<List<String>, List<q>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized Map<List<String>, List<q>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized Map<String, List<q>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final void getProductEntitlementMapping(k onSuccessHandler, k onErrorHandler) {
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path$default = Endpoint.getPath$default(getProductEntitlementMapping, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getProductEntitlementMapping, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        k kVar2 = (k) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(ProductEntitlementMapping.INSTANCE.fromNetwork(result.getBody(), result));
                            } catch (JSONException e10) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            kVar2.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path$default, w.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<k>> getRedeemWebPurchaseCallbacks() {
        return this.redeemWebPurchaseCallbacks;
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final void getVirtualCurrencies(String appUserID, boolean appInBackground, k onSuccess, k onError) throws Throwable {
        Delay delay;
        Throwable th;
        t.f(appUserID, "appUserID");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        final Endpoint.GetVirtualCurrencies getVirtualCurrencies = new Endpoint.GetVirtualCurrencies(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(dd.q.e(Endpoint.getPath$default(getVirtualCurrencies, false, 1, null)), appInBackground);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getVirtualCurrencies$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getVirtualCurrencies, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        k kVar2 = (k) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(result));
                            } catch (j e10) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e11) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e11);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            } catch (JSONException e12) {
                                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e12);
                                LogUtilsKt.errorLog(purchasesError3);
                                kVar2.invoke(purchasesError3);
                            }
                        } else {
                            PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError4);
                            kVar2.invoke(purchasesError4);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            if (appInBackground) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.virtualCurrenciesCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, w.a(onSuccess, onError), delay);
                h0 h0Var = h0.f3852a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<q>> getVirtualCurrenciesCallbacks() {
        return this.virtualCurrenciesCallbacks;
    }

    public final void getWebBillingProducts(String appUserID, Set<String> productIds, k onSuccess, k onError) throws Throwable {
        t.f(appUserID, "appUserID");
        t.f(productIds, "productIds");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        final Endpoint.WebBillingGetProducts webBillingGetProducts = new Endpoint.WebBillingGetProducts(appUserID, productIds);
        final String path$default = Endpoint.getPath$default(webBillingGetProducts, false, 1, null);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWebBillingProducts$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), webBillingGetProducts, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        k kVar2 = (k) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                eh.b json$purchases_defaultsBc8Release = Backend.INSTANCE.getJson$purchases_defaultsBc8Release();
                                String payload = result.getPayload();
                                json$purchases_defaultsBc8Release.a();
                                kVar.invoke((WebBillingProductsResponse) json$purchases_defaultsBc8Release.d(WebBillingProductsResponse.INSTANCE.serializer(), payload));
                            } catch (j e10) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e11) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e11);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            kVar2.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.webBillingProductsCallbacks, asyncCall, this.dispatcher, path$default, w.a(onSuccess, onError), Delay.NONE);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<q>> getWebBillingProductsCallbacks() {
        return this.webBillingProductsCallbacks;
    }

    public final void logIn(final String appUserID, final String newAppUserID, o onSuccessHandler, k onErrorHandler) {
        t.f(appUserID, "appUserID");
        t.f(newAppUserID, "newAppUserID");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final List listP = r.p(appUserID, newAppUserID);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, o0.l(w.a("app_user_id", appUserID), w.a("new_app_user_id", newAppUserID)), r.n(w.a("app_user_id", appUserID), w.a("new_app_user_id", newAppUserID)), this.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        o oVar = (o) qVar.a();
                        k kVar = (k) qVar.b();
                        boolean z10 = result.getResponseCode() == 201;
                        if (result.getBody().length() > 0) {
                            oVar.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z10));
                        } else {
                            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                            LogUtilsKt.errorLog(purchasesError2);
                            kVar.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.identifyCallbacks, asyncCall, this.dispatcher, listP, w.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postCreateSupportTicket(String appUserID, String email, String description, k onSuccessHandler, k onErrorHandler) {
        t.f(appUserID, "appUserID");
        t.f(email, "email");
        t.f(description, "description");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final Endpoint.PostCreateSupportTicket postCreateSupportTicket = Endpoint.PostCreateSupportTicket.INSTANCE;
        final String path$default = Endpoint.getPath$default(postCreateSupportTicket, false, 1, null);
        final Map mapL = o0.l(w.a(APP_USER_ID, appUserID), w.a("customer_email", email), w.a("issue_description", description));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postCreateSupportTicket$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postCreateSupportTicket, mapL, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        k kVar2 = (k) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(Boolean.valueOf(result.getBody().optBoolean("sent", false)));
                            } catch (j e10) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e10);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e11) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e11);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            kVar2.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getCreateSupportTicketCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((q) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback(this.createSupportTicketCallbacks, asyncCall, this.dispatcher, path$default, w.a(onSuccessHandler, onErrorHandler), Delay.NONE);
            h0 h0Var = h0.f3852a;
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, k onSuccessHandler, o onErrorHandler) throws Throwable {
        t.f(diagnosticsList, "diagnosticsList");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        final ArrayList arrayList = new ArrayList(s.u(diagnosticsList, 10));
        Iterator<T> it = diagnosticsList.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final Map mapE = n0.e(w.a("entries", new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.INSTANCE.getDiagnosticsURL(), Endpoint.PostDiagnostics.INSTANCE, mapE, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                List<String> list = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list);
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        o oVar = (o) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            kVar.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            oVar.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                List<String> list = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((o) ((q) it2.next()).b()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList, w.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                h0 h0Var = h0.f3852a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void postEvents(final EventsRequest paywallEventRequest, final URL baseURL, Delay delay, Function0 onSuccessHandler, o onErrorHandler) {
        t.f(paywallEventRequest, "paywallEventRequest");
        t.f(baseURL, "baseURL");
        t.f(delay, "delay");
        t.f(onSuccessHandler, "onSuccessHandler");
        t.f(onErrorHandler, "onErrorHandler");
        eh.b defaultJson = JsonProvider.INSTANCE.getDefaultJson();
        defaultJson.a();
        final Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(defaultJson.e(EventsRequest.INSTANCE.serializer(), paywallEventRequest));
        if (mapAsMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, Boolean.TRUE);
            return;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postEvents$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, baseURL, Endpoint.PostEvents.INSTANCE, mapAsMap, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    for (q qVar : listRemove) {
                        Function0 function0 = (Function0) qVar.a();
                        o oVar = (o) qVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function0.invoke();
                        } else {
                            oVar.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((o) ((q) it.next()).b()).invoke(error, Boolean.FALSE);
                    }
                }
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), w.a(onSuccessHandler, onErrorHandler), delay);
                h0 h0Var = h0.f3852a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean isRestore, boolean finishTransactions, Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes, ReceiptInfo receiptInfo, String storeAppUserID, String marketplace, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, k onSuccess, p onError) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Price price;
        LegacyProrationMode asLegacyProrationMode;
        PresentedOfferingContext.TargetingContext targetingContext;
        t.f(purchaseToken, "purchaseToken");
        t.f(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes2 = subscriberAttributes;
        t.f(subscriberAttributes2, "subscriberAttributes");
        t.f(receiptInfo, "receiptInfo");
        t.f(initiationSource, "initiationSource");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        final List listP = r.p(purchaseToken, appUserID, String.valueOf(isRestore), String.valueOf(finishTransactions), subscriberAttributes2.toString(), receiptInfo.toString(), storeAppUserID);
        q qVarA = w.a(FETCH_TOKEN, purchaseToken);
        q qVarA2 = w.a(DiagnosticsTracker.PRODUCT_IDS_KEY, receiptInfo.getProductIDs());
        List<PlatformProductId> platformProductIds$purchases_defaultsBc8Release = receiptInfo.getPlatformProductIds$purchases_defaultsBc8Release();
        if (platformProductIds$purchases_defaultsBc8Release != null) {
            arrayList = new ArrayList(s.u(platformProductIds$purchases_defaultsBc8Release, 10));
            Iterator<T> it = platformProductIds$purchases_defaultsBc8Release.iterator();
            while (it.hasNext()) {
                arrayList.add(((PlatformProductId) it.next()).getAsMap());
            }
        } else {
            arrayList = null;
        }
        q qVarA3 = w.a("platform_product_ids", arrayList);
        q qVarA4 = w.a(APP_USER_ID, appUserID);
        q qVarA5 = w.a("is_restore", Boolean.valueOf(isRestore));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        q qVarA6 = w.a("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = receiptInfo.getPresentedOfferingContext();
        q qVarA7 = w.a("presented_placement_identifier", presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext3 = receiptInfo.getPresentedOfferingContext();
        q qVarA8 = w.a("applied_targeting_rule", (presentedOfferingContext3 == null || (targetingContext = presentedOfferingContext3.getTargetingContext()) == null) ? null : o0.l(w.a("revision", Integer.valueOf(targetingContext.getRevision())), w.a("rule_id", targetingContext.getRuleId())));
        q qVarA9 = w.a("observer_mode", Boolean.valueOf(!finishTransactions));
        q qVarA10 = w.a("price", receiptInfo.getPrice());
        q qVarA11 = w.a("currency", receiptInfo.getCurrency());
        if (subscriberAttributes2.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes2 = null;
        }
        q qVarA12 = w.a("attributes", subscriberAttributes2);
        q qVarA13 = w.a("normal_duration", receiptInfo.getDuration());
        q qVarA14 = w.a("store_user_id", storeAppUserID);
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            arrayList2 = new ArrayList(s.u(pricingPhases, 10));
            Iterator<T> it2 = pricingPhases.iterator();
            while (it2.hasNext()) {
                arrayList2.add(BackendKt.toMap((PricingPhase) it2.next()));
            }
        } else {
            arrayList2 = null;
        }
        q qVarA15 = w.a("pricing_phases", arrayList2);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
        final Map mapFilterNotNullValues = MapExtensionsKt.filterNotNullValues(o0.l(qVarA, qVarA2, qVarA3, qVarA4, qVarA5, qVarA6, qVarA7, qVarA8, qVarA9, qVarA10, qVarA11, qVarA12, qVarA13, qVarA14, qVarA15, w.a("proration_mode", (googleReplacementMode == null || (asLegacyProrationMode = BackendKt.getAsLegacyProrationMode(googleReplacementMode)) == null) ? null : asLegacyProrationMode.name()), w.a("initiation_source", initiationSource.getPostReceiptFieldValue()), w.a("paywall", paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null)));
        final List listN = r.n(w.a(APP_USER_ID, appUserID), w.a(FETCH_TOKEN, purchaseToken));
        StoreProduct storeProduct = receiptInfo.getStoreProduct();
        final Map mapFilterNotNullValues2 = MapExtensionsKt.filterNotNullValues(o0.l(w.a("price_string", (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getFormatted()), w.a(com.amazon.a.a.o.b.f4559m, marketplace)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, mapFilterNotNullValues, listN, o0.p(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), mapFilterNotNullValues2), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<q> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Backend backend2 = this.this$0;
                    for (q qVar : listRemove) {
                        k kVar = (k) qVar.a();
                        p pVar = (p) qVar.b();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                kVar.invoke(PostReceiptResponseKt.buildPostReceiptResponse(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                pVar.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError), result.getBody());
                            }
                        } catch (JSONException e10) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e10);
                            LogUtilsKt.errorLog(purchasesError2);
                            pVar.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<q> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                List<String> list = listP;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it3 = listRemove.iterator();
                    while (it3.hasNext()) {
                        ((p) ((q) it3.next()).b()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listP, w.a(onSuccess, onError), null, 16, null);
            h0 h0Var = h0.f3852a;
        }
    }

    public final void postRedeemWebPurchase(String appUserID, String redemptionToken, k onResultHandler) throws Throwable {
        t.f(appUserID, "appUserID");
        t.f(redemptionToken, "redemptionToken");
        t.f(onResultHandler, "onResultHandler");
        final Endpoint.PostRedeemWebPurchase postRedeemWebPurchase = Endpoint.PostRedeemWebPurchase.INSTANCE;
        final String path$default = Endpoint.getPath$default(postRedeemWebPurchase, false, 1, null);
        final Map mapL = o0.l(w.a("redemption_token", redemptionToken), w.a(APP_USER_ID, appUserID));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postRedeemWebPurchase$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postRedeemWebPurchase, mapL, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsBc8Release(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<k> listRemove;
                t.f(result, "result");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (k kVar : listRemove) {
                        if (BackendHelperKt.isSuccessful(result)) {
                            kVar.invoke(new RedeemWebPurchaseListener.Result.Success(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result)));
                        } else {
                            Integer backendErrorCode = result.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidWebRedemptionToken.getValue();
                            if (backendErrorCode != null && backendErrorCode.intValue() == value) {
                                kVar.invoke(RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE);
                            } else {
                                int value2 = BackendErrorCode.BackendExpiredWebRedemptionToken.getValue();
                                if (backendErrorCode != null && backendErrorCode.intValue() == value2) {
                                    JSONObject body = result.getBody();
                                    JSONObject jSONObjectOptJSONObject = body.optJSONObject("purchase_redemption_error_info");
                                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("obfuscated_email") : null;
                                    if (strOptString == null) {
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing expired redemption token response: " + body, null);
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    } else {
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Expired(strOptString));
                                    }
                                } else {
                                    int value3 = BackendErrorCode.BackendPurchaseBelongsToOtherUser.getValue();
                                    if (backendErrorCode != null && backendErrorCode.intValue() == value3) {
                                        kVar.invoke(RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE);
                                    } else {
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<k> listRemove;
                t.f(error, "error");
                Backend backend = this.this$0;
                String str = path$default;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).invoke(new RedeemWebPurchaseListener.Result.Error(error));
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.redeemWebPurchaseCallbacks, asyncCall, this.dispatcher, path$default, onResultHandler, Delay.NONE);
                    h0 h0Var = h0.f3852a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized void setAliasCallbacks(Map<List<String>, List<q>> map) {
        t.f(map, "<set-?>");
        this.aliasCallbacks = map;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<q>> map) {
        t.f(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized void setCreateSupportTicketCallbacks(Map<String, List<q>> map) {
        t.f(map, "<set-?>");
        this.createSupportTicketCallbacks = map;
    }

    public final synchronized void setCustomerCenterCallbacks(Map<String, List<q>> map) {
        t.f(map, "<set-?>");
        this.customerCenterCallbacks = map;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<q>> map) {
        t.f(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<q>> map) {
        t.f(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<q>> map) {
        t.f(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<q>> map) {
        t.f(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<q>> map) {
        t.f(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<q>> map) {
        t.f(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final synchronized void setRedeemWebPurchaseCallbacks(Map<String, List<k>> map) {
        t.f(map, "<set-?>");
        this.redeemWebPurchaseCallbacks = map;
    }

    public final synchronized void setVirtualCurrenciesCallbacks(Map<BackgroundAwareCallbackCacheKey, List<q>> map) {
        t.f(map, "<set-?>");
        this.virtualCurrenciesCallbacks = map;
    }

    public final synchronized void setWebBillingProductsCallbacks(Map<String, List<q>> map) {
        t.f(map, "<set-?>");
        this.webBillingProductsCallbacks = map;
    }
}
