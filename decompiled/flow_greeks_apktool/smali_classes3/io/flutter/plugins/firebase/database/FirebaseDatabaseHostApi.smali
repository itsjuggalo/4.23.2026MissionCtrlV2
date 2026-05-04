.class public interface abstract Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u0000 82\u00020\u0001:\u00018J1\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u0008\u0010\tJ1\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\n\u0010\tJ9\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\r\u0010\u000eJ9\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000c\u001a\u00020\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u0013\u0010\u000eJA\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u0017\u0010\u0018J;\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u001b\u0010\u001cJ9\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u001e\u0010\u001cJ1\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\u001f\u0010\tJ9\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008\"\u0010#J9\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008$\u0010#J9\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020%2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008&\u0010\'J9\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008(\u0010#J9\u0010*\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020)2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008*\u0010+JG\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u000f2&\u0010\u0007\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008.\u0010\u0012J9\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u0008/\u0010#J9\u00100\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00080\u0010#J9\u00101\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020%2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00081\u0010\'J9\u00102\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00082\u0010\u001cJ9\u00104\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00084\u00105J9\u00106\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00086\u00105JG\u00107\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032&\u0010\u0007\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a2\u0006\u0004\u00087\u00105\u00a8\u00069"
    }
    d2 = {
        "Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;",
        "",
        "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
        "app",
        "Lkotlin/Function1;",
        "Lcd/r;",
        "Lcd/h0;",
        "callback",
        "goOnline",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V",
        "goOffline",
        "",
        "enabled",
        "setPersistenceEnabled",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;ZLpd/k;)V",
        "",
        "cacheSize",
        "setPersistenceCacheSizeBytes",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;JLpd/k;)V",
        "setLoggingEnabled",
        "",
        "host",
        "port",
        "useDatabaseEmulator",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;JLpd/k;)V",
        "path",
        "Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform;",
        "ref",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V",
        "url",
        "refFromURL",
        "purgeOutstandingWrites",
        "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
        "request",
        "databaseReferenceSet",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V",
        "databaseReferenceSetWithPriority",
        "Lio/flutter/plugins/firebase/database/UpdateRequest;",
        "databaseReferenceUpdate",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/UpdateRequest;Lpd/k;)V",
        "databaseReferenceSetPriority",
        "Lio/flutter/plugins/firebase/database/TransactionRequest;",
        "databaseReferenceRunTransaction",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/TransactionRequest;Lpd/k;)V",
        "transactionKey",
        "",
        "databaseReferenceGetTransactionResult",
        "onDisconnectSet",
        "onDisconnectSetWithPriority",
        "onDisconnectUpdate",
        "onDisconnectCancel",
        "Lio/flutter/plugins/firebase/database/QueryRequest;",
        "queryObserve",
        "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V",
        "queryKeepSynced",
        "queryGet",
        "Companion",
        "firebase_database_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x1,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final Companion:Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    sget-object v0, Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;->$$INSTANCE:Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;

    .line 2
    .line 3
    sput-object v0, Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;->Companion:Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;

    .line 4
    .line 5
    return-void
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method


# virtual methods
.method public abstract databaseReferenceGetTransactionResult(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;JLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "J",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract databaseReferenceRunTransaction(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/TransactionRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/TransactionRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract databaseReferenceSet(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract databaseReferenceSetPriority(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract databaseReferenceSetWithPriority(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract databaseReferenceUpdate(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/UpdateRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/UpdateRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract goOffline(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract goOnline(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onDisconnectCancel(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Ljava/lang/String;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onDisconnectSet(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onDisconnectSetWithPriority(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract onDisconnectUpdate(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/UpdateRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/UpdateRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract purgeOutstandingWrites(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract queryGet(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/QueryRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract queryKeepSynced(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/QueryRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract queryObserve(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Lio/flutter/plugins/firebase/database/QueryRequest;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract ref(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Ljava/lang/String;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract refFromURL(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Ljava/lang/String;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setLoggingEnabled(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;ZLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Z",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setPersistenceCacheSizeBytes(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;JLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "J",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setPersistenceEnabled(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;ZLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Z",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract useDatabaseEmulator(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;JLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;",
            "Ljava/lang/String;",
            "J",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method
