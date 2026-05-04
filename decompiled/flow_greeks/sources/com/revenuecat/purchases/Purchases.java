package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import cd.g0;
import cd.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.DeepLinkParser;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.utils.DefaultIsDebugBuildProvider;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import dd.a0;
import dd.q;
import dd.r;
import dd.t0;
import io.flutter.plugins.firebase.auth.Constants;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b4\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ï\u00012\u00020\u0001:\u0002ï\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\"¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\u0006\u0010\u000b\u001a\u00020'¢\u0006\u0004\b(\u0010)J/\u0010(\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u000b\u001a\u00020'¢\u0006\u0004\b(\u0010,J\u001d\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020/¢\u0006\u0004\b0\u00101J'\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u0010\u000b\u001a\u00020/H\u0007¢\u0006\u0004\b6\u00107J'\u0010:\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00109\u001a\u0002082\u0006\u0010\u0012\u001a\u00020/H\u0007¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020<¢\u0006\u0004\b=\u0010>J#\u0010A\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00152\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010@H\u0007¢\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010<H\u0007¢\u0006\u0004\bC\u0010>J\r\u0010D\u001a\u00020\u0006¢\u0006\u0004\bD\u0010\bJ\u0015\u0010E\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020<¢\u0006\u0004\bE\u0010>J\u001d\u0010E\u001a\u00020\u00062\u0006\u0010G\u001a\u00020F2\u0006\u0010\u000b\u001a\u00020<¢\u0006\u0004\bE\u0010HJ\u0015\u0010J\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020I¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020\u0006¢\u0006\u0004\bL\u0010\bJ\r\u0010M\u001a\u00020\u0006¢\u0006\u0004\bM\u0010\bJ'\u0010P\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u000e\b\u0002\u0010O\u001a\b\u0012\u0004\u0012\u00020N0%H\u0007¢\u0006\u0004\bP\u0010QJ\r\u0010R\u001a\u00020\u0006¢\u0006\u0004\bR\u0010\bJ\u0017\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0007¢\u0006\u0004\bU\u0010VJ\u0017\u0010Z\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020WH\u0000¢\u0006\u0004\bX\u0010YJG\u0010b\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\u00152\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u00060]2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00060]H\u0007¢\u0006\u0004\bb\u0010cJ#\u0010f\u001a\u00020\u00062\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00150d¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00062\b\u0010[\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bh\u0010iJ\u0017\u0010k\u001a\u00020\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bk\u0010iJ\u0017\u0010m\u001a\u00020\u00062\b\u0010l\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bm\u0010iJ\u0017\u0010o\u001a\u00020\u00062\b\u0010n\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bo\u0010iJ\u0017\u0010q\u001a\u00020\u00062\b\u0010p\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bq\u0010iJ\u0017\u0010s\u001a\u00020\u00062\b\u0010r\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bs\u0010iJ\u0017\u0010u\u001a\u00020\u00062\b\u0010t\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bu\u0010iJ\u0017\u0010w\u001a\u00020\u00062\b\u0010v\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bw\u0010iJ\u0017\u0010y\u001a\u00020\u00062\b\u0010x\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\by\u0010iJ\u0017\u0010{\u001a\u00020\u00062\b\u0010z\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b{\u0010iJ\u0017\u0010}\u001a\u00020\u00062\b\u0010|\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b}\u0010iJ\r\u0010~\u001a\u00020\u0006¢\u0006\u0004\b~\u0010\bJ\u0019\u0010\u0080\u0001\u001a\u00020\u00062\b\u0010\u007f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0080\u0001\u0010iJ\u001a\u0010\u0082\u0001\u001a\u00020\u00062\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0082\u0001\u0010iJ\u001a\u0010\u0084\u0001\u001a\u00020\u00062\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0084\u0001\u0010iJ\u001a\u0010\u0086\u0001\u001a\u00020\u00062\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0086\u0001\u0010iJ\u001a\u0010\u0088\u0001\u001a\u00020\u00062\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0088\u0001\u0010iJ\u001a\u0010\u008a\u0001\u001a\u00020\u00062\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u008a\u0001\u0010iJ\u001a\u0010\u008c\u0001\u001a\u00020\u00062\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u008c\u0001\u0010iJ\u001a\u0010\u008e\u0001\u001a\u00020\u00062\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u008e\u0001\u0010iJ\u001a\u0010\u0090\u0001\u001a\u00020\u00062\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0090\u0001\u0010iJ\u001a\u0010\u0092\u0001\u001a\u00020\u00062\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0092\u0001\u0010iJ\u001a\u0010\u0094\u0001\u001a\u00020\u00062\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0094\u0001\u0010iJ\u001a\u0010\u0096\u0001\u001a\u00020\u00062\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001a\u0010\u0098\u0001\u001a\u00020\u00062\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0005\b\u0098\u0001\u0010iJ\u001f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00012\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001H\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u001b\u0010\u009f\u0001\u001a\u00020^2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0015¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J'\u0010¡\u0001\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\u0006\u0010\u000b\u001a\u00020'H\u0007¢\u0006\u0005\b¡\u0001\u0010)J'\u0010¢\u0001\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\u0006\u0010\u000b\u001a\u00020'H\u0007¢\u0006\u0005\b¢\u0001\u0010)J\u0019\u0010¤\u0001\u001a\u00020\u00062\u0007\u0010\u000b\u001a\u00030£\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001J#\u0010©\u0001\u001a\u00020\u00062\b\u0010§\u0001\u001a\u00030¦\u00012\u0007\u0010\u0012\u001a\u00030¨\u0001¢\u0006\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R1\u0010´\u0001\u001a\u00020^2\u0007\u0010®\u0001\u001a\u00020^8F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\b³\u0001\u0010\b\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R \u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b·\u0001\u0010\b\u001a\u0005\b\u000f\u0010¶\u0001R\u001f\u0010½\u0001\u001a\u00030¹\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b¼\u0001\u0010\b\u001a\u0006\bº\u0001\u0010»\u0001R\u001f\u0010Â\u0001\u001a\u00030¾\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\bÁ\u0001\u0010\b\u001a\u0006\b¿\u0001\u0010À\u0001R1\u0010Æ\u0001\u001a\u00020^2\u0007\u0010®\u0001\u001a\u00020^8F@FX\u0087\u000e¢\u0006\u0017\u0012\u0005\bÅ\u0001\u0010\b\u001a\u0006\bÃ\u0001\u0010°\u0001\"\u0006\bÄ\u0001\u0010²\u0001R\u0015\u0010Ê\u0001\u001a\u00030Ç\u00018F¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001R,\u0010Ð\u0001\u001a\u00030Ë\u00012\b\u0010®\u0001\u001a\u00030Ë\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0014\u0010Ó\u0001\u001a\u00020\u00158F¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0015\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0007\u001a\u0005\b\f\u0010Ò\u0001R0\u0010Ú\u0001\u001a\u0005\u0018\u00010Õ\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010Õ\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R9\u0010ã\u0001\u001a\u0005\u0018\u00010Û\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001*\u0006\bá\u0001\u0010â\u0001R\u0014\u0010ä\u0001\u001a\u00020^8F¢\u0006\b\u001a\u0006\bä\u0001\u0010°\u0001R\u0015\u0010è\u0001\u001a\u00030å\u00018F¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0017\u0010ì\u0001\u001a\u0005\u0018\u00010é\u00018F¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0016\u0010î\u0001\u001a\u0004\u0018\u00010\u00158F¢\u0006\b\u001a\u0006\bí\u0001\u0010Ò\u0001¨\u0006ð\u0001"}, d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "purchasesOrchestrator", "<init>", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)V", "Lcd/h0;", "onAppBackgrounded", "()V", "onAppForegrounded", "Lcom/revenuecat/purchases/interfaces/GetStorefrontCallback;", "callback", "getStorefrontCountryCode", "(Lcom/revenuecat/purchases/interfaces/GetStorefrontCallback;)V", "Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;", "getStorefrontLocale", "(Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;)V", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "listener", "syncPurchases", "(Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;)V", "", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", "", "price", "syncObserverModeAmazonPurchase", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "syncAmazonPurchase", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "syncAttributesAndOfferingsIfNeeded", "(Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;)V", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getOfferings", "(Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;)V", "", "productIds", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getProducts", "(Ljava/util/List;Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;)V", "Lcom/revenuecat/purchases/ProductType;", "type", "(Ljava/util/List;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;)V", "Lcom/revenuecat/purchases/PurchaseParams;", "purchaseParams", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", FirebaseAnalytics.Event.PURCHASE, "(Lcom/revenuecat/purchases/PurchaseParams;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "Landroid/app/Activity;", "activity", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProduct", "purchaseProduct", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "Lcom/revenuecat/purchases/Package;", "packageToPurchase", "purchasePackage", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/interfaces/PurchaseCallback;)V", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "restorePurchases", "(Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;)V", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logIn", "(Ljava/lang/String;Lcom/revenuecat/purchases/interfaces/LogInCallback;)V", "logOut", "close", "getCustomerInfo", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "fetchPolicy", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;)V", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "getVirtualCurrencies", "(Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;)V", "invalidateVirtualCurrenciesCache", "removeUpdatedCustomerInfoListener", "Lcom/revenuecat/purchases/models/InAppMessageType;", "inAppMessageTypes", "showInAppMessagesIfNeeded", "(Landroid/app/Activity;Ljava/util/List;)V", "invalidateCustomerInfoCache", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "event", "track", "(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "getCustomerCenterConfigData$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;)V", "getCustomerCenterConfigData", Constants.EMAIL, com.amazon.a.a.o.b.f4549c, "Lkotlin/Function1;", "", "onSuccess", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "createSupportTicket", "(Ljava/lang/String;Ljava/lang/String;Lpd/k;Lpd/k;)V", "", "attributes", "setAttributes", "(Ljava/util/Map;)V", "setEmail", "(Ljava/lang/String;)V", "phoneNumber", "setPhoneNumber", "displayName", "setDisplayName", "fcmToken", "setPushToken", "mixpanelDistinctID", "setMixpanelDistinctID", "onesignalID", "setOnesignalID", "onesignalUserID", "setOnesignalUserID", "airshipChannelID", "setAirshipChannelID", "firebaseAppInstanceID", "setFirebaseAppInstanceID", "tenjinAnalyticsInstallationID", "setTenjinAnalyticsInstallationID", "postHogUserId", "setPostHogUserId", "collectDeviceIdentifiers", "adjustID", "setAdjustID", "appsflyerID", "setAppsflyerID", "fbAnonymousID", "setFBAnonymousID", "mparticleID", "setMparticleID", "cleverTapID", "setCleverTapID", "kochavaDeviceID", "setKochavaDeviceID", "airbridgeDeviceID", "setAirbridgeDeviceID", "mediaSource", "setMediaSource", FirebaseAnalytics.Param.CAMPAIGN, "setCampaign", "adGroup", "setAdGroup", "ad", "setAd", "keyword", "setKeyword", "creative", "setCreative", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "fontInfo", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "getCachedFontFamilyOrStartDownload", "(Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;)Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "localeString", "overridePreferredUILocale", "(Ljava/lang/String;)Z", "getSubscriptionSkus", "getNonSubscriptionSkus", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "getAmazonLWAConsentStatus", "(Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;)V", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "webPurchaseRedemption", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "redeemWebPurchase", "(Lcom/revenuecat/purchases/WebPurchaseRedemption;Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;)V", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "getPurchasesOrchestrator$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PurchasesOrchestrator;", "value", "getFinishTransactions", "()Z", "setFinishTransactions", "(Z)V", "getFinishTransactions$annotations", "finishTransactions", "Ljava/util/Locale;", "()Ljava/util/Locale;", "getStorefrontLocale$annotations", "storefrontLocale", "Lcom/revenuecat/purchases/storage/FileRepository;", "getFileRepository", "()Lcom/revenuecat/purchases/storage/FileRepository;", "getFileRepository$annotations", "fileRepository", "Lcom/revenuecat/purchases/ads/events/AdTracker;", "getAdTracker", "()Lcom/revenuecat/purchases/ads/events/AdTracker;", "getAdTracker$annotations", "adTracker", "getAllowSharingPlayStoreAccount", "setAllowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount$annotations", "allowSharingPlayStoreAccount", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "getCurrentConfiguration", "()Lcom/revenuecat/purchases/PurchasesConfiguration;", "currentConfiguration", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "setPurchasesAreCompletedBy", "(Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)V", "purchasesAreCompletedBy", "getAppUserID", "()Ljava/lang/String;", "appUserID", "storefrontCountryCode", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "updatedCustomerInfoListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "<set-?>", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "setCustomerCenterListener", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "getCustomerCenterListener$delegate", "(Lcom/revenuecat/purchases/Purchases;)Ljava/lang/Object;", "customerCenterListener", "isAnonymous", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getCachedVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "cachedVirtualCurrencies", "getPreferredUILocaleOverride", "preferredUILocaleOverride", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Purchases implements LifecycleDelegate {
    private static /* synthetic */ Purchases backingFieldSharedInstance;
    private final PurchasesOrchestrator purchasesOrchestrator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String frameworkVersion = "9.15.5";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000b\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001dR*\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\u0003\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010+\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00198F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u0003\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u00102\u001a\u00020,2\u0006\u0010\u001f\u001a\u00020,8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0003\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00109\u001a\u0002032\u0006\u0010\u001f\u001a\u0002038F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\u0003\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u0010?\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00128F@AX\u0087\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\u0003\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R \u0010@\u001a\u00020\r8\u0006X\u0087D¢\u0006\u0012\n\u0004\b@\u0010A\u0012\u0004\bD\u0010\u0003\u001a\u0004\bB\u0010CR.\u0010K\u001a\u0004\u0018\u00010E2\b\u0010\u001f\u001a\u0004\u0018\u00010E8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\u0003\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010L\u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0003\u001a\u0004\bL\u0010'R$\u0010N\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010;\"\u0004\bQ\u0010=¨\u0006R"}, d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "getImageLoader", "(Landroid/content/Context;)Ljava/lang/Object;", "Landroid/content/Intent;", "intent", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "parseAsWebPurchaseRedemption", "(Landroid/content/Intent;)Lcom/revenuecat/purchases/WebPurchaseRedemption;", "", "string", "(Ljava/lang/String;)Lcom/revenuecat/purchases/WebPurchaseRedemption;", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "configuration", "Lcom/revenuecat/purchases/Purchases;", "configure", "(Lcom/revenuecat/purchases/PurchasesConfiguration;)Lcom/revenuecat/purchases/Purchases;", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "features", "Lcom/revenuecat/purchases/interfaces/Callback;", "", "callback", "Lcd/h0;", "canMakePayments", "(Landroid/content/Context;Ljava/util/List;Lcom/revenuecat/purchases/interfaces/Callback;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "value", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "getPlatformInfo$annotations", "platformInfo", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "getDebugLogsEnabled$annotations", "debugLogsEnabled", "Lcom/revenuecat/purchases/LogLevel;", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "getLogLevel$annotations", "logLevel", "Lcom/revenuecat/purchases/LogHandler;", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "getLogHandler$annotations", "logHandler", "getSharedInstance", "()Lcom/revenuecat/purchases/Purchases;", "setSharedInstance$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/Purchases;)V", "getSharedInstance$annotations", "sharedInstance", "frameworkVersion", "Ljava/lang/String;", "getFrameworkVersion", "()Ljava/lang/String;", "getFrameworkVersion$annotations", "Ljava/net/URL;", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "getProxyURL$annotations", "proxyURL", "isConfigured", "isConfigured$annotations", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_defaultsBc8Release", "setBackingFieldSharedInstance$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                list = r.k();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            t.f(context, "context");
            t.f(callback, "callback");
            canMakePayments$default(this, context, null, callback, 2, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Purchases configure(PurchasesConfiguration configuration) {
            PurchasesOrchestrator purchasesOrchestrator;
            t.f(configuration, "configuration");
            APIKeyValidator aPIKeyValidator = null;
            Object[] objArr = 0;
            if (isConfigured()) {
                Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
                if (t.b((backingFieldSharedInstance$purchases_defaultsBc8Release == null || (purchasesOrchestrator = backingFieldSharedInstance$purchases_defaultsBc8Release.getPurchasesOrchestrator()) == null) ? null : purchasesOrchestrator.getCurrentConfiguration(), configuration)) {
                    LogLevel logLevel = LogLevel.INFO;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.i("[Purchases] - " + logLevel.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS_WITH_SAME_CONFIG);
                    }
                    return getSharedInstance();
                }
                LogLevel logLevel2 = LogLevel.INFO;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.i("[Purchases] - " + logLevel2.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS);
                }
            }
            Purchases purchasesCreatePurchases$default = PurchasesFactory.createPurchases$default(new PurchasesFactory(new DefaultIsDebugBuildProvider(configuration.getContext()), aPIKeyValidator, 2, objArr == true ? 1 : 0), configuration, getPlatformInfo(), getProxyURL(), null, null, false, false, null, 248, null);
            Purchases.INSTANCE.setSharedInstance$purchases_defaultsBc8Release(purchasesCreatePurchases$default);
            return purchasesCreatePurchases$default;
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsBc8Release() {
            return Purchases.backingFieldSharedInstance;
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.INSTANCE.getDebugLogsEnabled();
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        @InternalRevenueCatAPI
        public final Object getImageLoader(Context context) {
            t.f(context, "context");
            return PurchasesOrchestrator.INSTANCE.getImageLoader(context);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.INSTANCE.getLogHandler();
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.INSTANCE.getLogLevel();
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.INSTANCE.getPlatformInfo();
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.INSTANCE.getProxyURL();
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                return backingFieldSharedInstance$purchases_defaultsBc8Release;
            }
            throw new g0(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsBc8Release() != null;
        }

        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
            t.f(intent, "intent");
            Uri data = intent.getData();
            if (data == null) {
                return null;
            }
            return DeepLinkParser.INSTANCE.parseWebPurchaseRedemption(data);
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsBc8Release(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final void setDebugLogsEnabled(boolean z10) {
            PurchasesOrchestrator.INSTANCE.setDebugLogsEnabled(z10);
        }

        public final synchronized void setLogHandler(LogHandler value) {
            t.f(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogHandler(value);
        }

        public final void setLogLevel(LogLevel value) {
            t.f(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogLevel(value);
        }

        public final void setPlatformInfo(PlatformInfo value) {
            t.f(value, "value");
            PurchasesOrchestrator.INSTANCE.setPlatformInfo(value);
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.INSTANCE.setProxyURL(url);
        }

        public final void setSharedInstance$purchases_defaultsBc8Release(Purchases value) {
            t.f(value, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                backingFieldSharedInstance$purchases_defaultsBc8Release.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsBc8Release(value);
        }

        private Companion() {
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            t.f(context, "context");
            t.f(features, "features");
            t.f(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator().getAppConfig().getStore() == Store.PLAY_STORE) {
                PurchasesOrchestrator.INSTANCE.canMakePayments(context, features, callback);
                return;
            }
            LogIntent logIntent = LogIntent.RC_ERROR;
            Purchases$Companion$canMakePayments$$inlined$log$1 purchases$Companion$canMakePayments$$inlined$log$1 = new Purchases$Companion$canMakePayments$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchases$Companion$canMakePayments$$inlined$log$1.invoke(), null);
                    break;
            }
            callback.onReceived(Boolean.TRUE);
        }

        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(String string) {
            t.f(string, "string");
            try {
                Uri uri = Uri.parse(string);
                DeepLinkParser deepLinkParser = DeepLinkParser.INSTANCE;
                t.e(uri, "uri");
                return deepLinkParser.parseWebPurchaseRedemption(uri);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing URL: " + string, th);
                return null;
            }
        }

        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        public static /* synthetic */ void getLogHandler$annotations() {
        }

        public static /* synthetic */ void getLogLevel$annotations() {
        }

        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        public static /* synthetic */ void getProxyURL$annotations() {
        }

        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        public static /* synthetic */ void isConfigured$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Purchases(PurchasesOrchestrator purchasesOrchestrator) {
        t.f(purchasesOrchestrator, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator;
    }

    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, callback);
    }

    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return INSTANCE.configure(purchasesConfiguration);
    }

    public static final boolean getDebugLogsEnabled() {
        return INSTANCE.getDebugLogsEnabled();
    }

    public static final String getFrameworkVersion() {
        return INSTANCE.getFrameworkVersion();
    }

    public static final synchronized LogHandler getLogHandler() {
        return INSTANCE.getLogHandler();
    }

    public static final LogLevel getLogLevel() {
        return INSTANCE.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return INSTANCE.getPlatformInfo();
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public static final URL getProxyURL() {
        return INSTANCE.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return INSTANCE.getSharedInstance();
    }

    public static final boolean isConfigured() {
        return INSTANCE.isConfigured();
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
        return INSTANCE.parseAsWebPurchaseRedemption(intent);
    }

    public static final void setDebugLogsEnabled(boolean z10) {
        INSTANCE.setDebugLogsEnabled(z10);
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        INSTANCE.setLogHandler(logHandler);
    }

    public static final void setLogLevel(LogLevel logLevel) {
        INSTANCE.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        INSTANCE.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        INSTANCE.setProxyURL(url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = q.e(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public final void close() {
        this.purchasesOrchestrator.close();
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    @InternalRevenueCatAPI
    public final void createSupportTicket(String email, String description, pd.k onSuccess, pd.k onError) {
        t.f(email, "email");
        t.f(description, "description");
        t.f(onSuccess, "onSuccess");
        t.f(onError, "onError");
        this.purchasesOrchestrator.createSupportTicket(email, description, onSuccess, onError);
    }

    public final /* synthetic */ AdTracker getAdTracker() {
        return this.purchasesOrchestrator.getAdTracker();
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final void getAmazonLWAConsentStatus(GetAmazonLWAConsentStatusCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getAmazonLWAConsentStatus(callback);
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    @InternalRevenueCatAPI
    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        t.f(fontInfo, "fontInfo");
        return this.purchasesOrchestrator.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.purchasesOrchestrator.getCachedVirtualCurrencies();
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.purchasesOrchestrator.getCurrentConfiguration();
    }

    public final void getCustomerCenterConfigData$purchases_defaultsBc8Release(GetCustomerCenterConfigCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getCustomerCenterConfig(callback);
    }

    public final CustomerCenterListener getCustomerCenterListener() {
        return this.purchasesOrchestrator.getCustomerCenterListener();
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.INSTANCE.m19default(), true, callback);
    }

    public final /* synthetic */ FileRepository getFileRepository() {
        return this.purchasesOrchestrator.getFileRepository();
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    public final void getNonSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        t.f(productIds, "productIds");
        t.f(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(a0.N0(productIds), t0.c(ProductType.INAPP), callback);
    }

    public final void getOfferings(ReceiveOfferingsCallback listener) {
        t.f(listener, "listener");
        PurchasesOrchestrator.getOfferings$default(this.purchasesOrchestrator, listener, false, 2, null);
    }

    public final synchronized String getPreferredUILocaleOverride() {
        return this.purchasesOrchestrator.get_preferredUILocaleOverride();
    }

    public final void getProducts(List<String> productIds, GetStoreProductsCallback callback) {
        t.f(productIds, "productIds");
        t.f(callback, "callback");
        getProducts(productIds, null, callback);
    }

    public final synchronized PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.purchasesOrchestrator.getFinishTransactions() ? PurchasesAreCompletedBy.REVENUECAT : PurchasesAreCompletedBy.MY_APP;
    }

    /* JADX INFO: renamed from: getPurchasesOrchestrator$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator() {
        return this.purchasesOrchestrator;
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    public final synchronized String getStorefrontCountryCode() {
        return this.purchasesOrchestrator.getStorefrontCountryCode();
    }

    public final Locale getStorefrontLocale() {
        return this.purchasesOrchestrator.getStorefrontLocale();
    }

    public final void getSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        t.f(productIds, "productIds");
        t.f(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(a0.N0(productIds), t0.c(ProductType.SUBS), callback);
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getVirtualCurrencies(callback);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.purchasesOrchestrator.invalidateVirtualCurrenciesCache();
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final void logIn(String newAppUserID) {
        t.f(newAppUserID, "newAppUserID");
        logIn$default(this, newAppUserID, null, 2, null);
    }

    public final void logOut() {
        logOut$default(this, null, 1, null);
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public final boolean overridePreferredUILocale(String localeString) {
        return this.purchasesOrchestrator.overridePreferredUILocale(localeString);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) {
        t.f(purchaseParams, "purchaseParams");
        t.f(callback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, callback);
    }

    public final void purchasePackage(Activity activity, Package packageToPurchase, PurchaseCallback listener) {
        t.f(activity, "activity");
        t.f(packageToPurchase, "packageToPurchase");
        t.f(listener, "listener");
        purchase(new PurchaseParams.Builder(activity, packageToPurchase).build(), listener);
    }

    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback callback) {
        t.f(activity, "activity");
        t.f(storeProduct, "storeProduct");
        t.f(callback, "callback");
        purchase(new PurchaseParams.Builder(activity, storeProduct).build(), callback);
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        t.f(webPurchaseRedemption, "webPurchaseRedemption");
        t.f(listener, "listener");
        this.purchasesOrchestrator.redeemWebPurchase(webPurchaseRedemption, listener);
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.restorePurchases(callback);
    }

    public final void setAd(String ad2) {
        this.purchasesOrchestrator.setAd(ad2);
    }

    public final void setAdGroup(String adGroup) {
        this.purchasesOrchestrator.setAdGroup(adGroup);
    }

    public final void setAdjustID(String adjustID) {
        this.purchasesOrchestrator.setAdjustID(adjustID);
    }

    public final void setAirbridgeDeviceID(String airbridgeDeviceID) {
        this.purchasesOrchestrator.setAirbridgeDeviceID(airbridgeDeviceID);
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        this.purchasesOrchestrator.setAirshipChannelID(airshipChannelID);
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z10) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z10);
    }

    public final void setAppsflyerID(String appsflyerID) {
        this.purchasesOrchestrator.setAppsflyerID(appsflyerID);
    }

    public final void setAttributes(Map<String, String> attributes) {
        t.f(attributes, "attributes");
        this.purchasesOrchestrator.setAttributes(attributes);
    }

    public final void setCampaign(String campaign) {
        this.purchasesOrchestrator.setCampaign(campaign);
    }

    public final void setCleverTapID(String cleverTapID) {
        this.purchasesOrchestrator.setCleverTapID(cleverTapID);
    }

    public final void setCreative(String creative) {
        this.purchasesOrchestrator.setCreative(creative);
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.purchasesOrchestrator.setCustomerCenterListener(customerCenterListener);
    }

    public final void setDisplayName(String displayName) {
        this.purchasesOrchestrator.setDisplayName(displayName);
    }

    public final void setEmail(String email) {
        this.purchasesOrchestrator.setEmail(email);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        this.purchasesOrchestrator.setFBAnonymousID(fbAnonymousID);
    }

    public final synchronized void setFinishTransactions(boolean z10) {
        this.purchasesOrchestrator.setFinishTransactions(z10);
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(firebaseAppInstanceID);
    }

    public final void setKeyword(String keyword) {
        this.purchasesOrchestrator.setKeyword(keyword);
    }

    public final void setKochavaDeviceID(String kochavaDeviceID) {
        this.purchasesOrchestrator.setKochavaDeviceID(kochavaDeviceID);
    }

    public final void setMediaSource(String mediaSource) {
        this.purchasesOrchestrator.setMediaSource(mediaSource);
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        this.purchasesOrchestrator.setMixpanelDistinctID(mixpanelDistinctID);
    }

    public final void setMparticleID(String mparticleID) {
        this.purchasesOrchestrator.setMparticleID(mparticleID);
    }

    public final void setOnesignalID(String onesignalID) {
        this.purchasesOrchestrator.setOnesignalID(onesignalID);
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        this.purchasesOrchestrator.setOnesignalUserID(onesignalUserID);
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.purchasesOrchestrator.setPhoneNumber(phoneNumber);
    }

    public final void setPostHogUserId(String postHogUserId) {
        this.purchasesOrchestrator.setPostHogUserId(postHogUserId);
    }

    public final synchronized void setPurchasesAreCompletedBy(PurchasesAreCompletedBy value) {
        try {
            t.f(value, "value");
            PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
            int i10 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            boolean z10 = true;
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new o();
                }
                z10 = false;
            }
            purchasesOrchestrator.setFinishTransactions(z10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setPushToken(String fcmToken) {
        this.purchasesOrchestrator.setPushToken(fcmToken);
    }

    public final void setTenjinAnalyticsInstallationID(String tenjinAnalyticsInstallationID) {
        this.purchasesOrchestrator.setTenjinAnalyticsInstallationID(tenjinAnalyticsInstallationID);
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        t.f(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, null, 2, null);
    }

    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        t.f(productID, "productID");
        t.f(receiptID, "receiptID");
        t.f(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price);
    }

    public final void syncAttributesAndOfferingsIfNeeded(SyncAttributesAndOfferingsCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.syncAttributesAndOfferingsIfNeeded(callback);
    }

    public final void syncObserverModeAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        t.f(productID, "productID");
        t.f(receiptID, "receiptID");
        t.f(amazonUserID, "amazonUserID");
        syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, null, 1, null);
    }

    @InternalRevenueCatAPI
    public final /* synthetic */ void track(FeatureEvent event) {
        t.f(event, "event");
        this.purchasesOrchestrator.track(event);
    }

    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, list, callback);
    }

    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(String str) {
        return INSTANCE.parseAsWebPurchaseRedemption(str);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        t.f(fetchPolicy, "fetchPolicy");
        t.f(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(fetchPolicy, true, callback);
    }

    public final void getProducts(List<String> productIds, ProductType type, GetStoreProductsCallback callback) {
        t.f(productIds, "productIds");
        t.f(callback, "callback");
        this.purchasesOrchestrator.getProducts(productIds, type, callback);
    }

    public final void getStorefrontCountryCode(GetStorefrontCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getStorefrontCountryCode(callback);
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public final void getStorefrontLocale(GetStorefrontLocaleCallback callback) {
        t.f(callback, "callback");
        this.purchasesOrchestrator.getStorefrontLocale(callback);
    }

    public final void logIn(String newAppUserID, LogInCallback callback) {
        t.f(newAppUserID, "newAppUserID");
        this.purchasesOrchestrator.logIn(newAppUserID, callback);
    }

    public final void logOut(ReceiveCustomerInfoCallback callback) {
        this.purchasesOrchestrator.logOut(callback);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        t.f(activity, "activity");
        t.f(inAppMessageTypes, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, inAppMessageTypes);
    }

    public final void syncPurchases(SyncPurchasesCallback listener) {
        this.purchasesOrchestrator.syncPurchases(listener);
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getAdTracker$annotations() {
    }

    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getFileRepository$annotations() {
    }

    public static /* synthetic */ void getFinishTransactions$annotations() {
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static /* synthetic */ void getStorefrontLocale$annotations() {
    }
}
