.class public final Lio/flutter/plugins/firebase/database/FirebaseDatabasePlugin$queryObserve$streamHandler$1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lio/flutter/plugins/firebase/database/OnDispose;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/firebase/database/FirebaseDatabasePlugin;->queryObserve(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\u0008\u0003\u0010\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "io/flutter/plugins/firebase/database/FirebaseDatabasePlugin$queryObserve$streamHandler$1",
        "Lio/flutter/plugins/firebase/database/OnDispose;",
        "Lcd/h0;",
        "run",
        "()V",
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


# instance fields
.field final synthetic $eventChannel:Lio/flutter/plugin/common/EventChannel;


# direct methods
.method public constructor <init>(Lio/flutter/plugin/common/EventChannel;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/flutter/plugins/firebase/database/FirebaseDatabasePlugin$queryObserve$streamHandler$1;->$eventChannel:Lio/flutter/plugin/common/EventChannel;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/flutter/plugins/firebase/database/FirebaseDatabasePlugin$queryObserve$streamHandler$1;->$eventChannel:Lio/flutter/plugin/common/EventChannel;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, v1}, Lio/flutter/plugin/common/EventChannel;->setStreamHandler(Lio/flutter/plugin/common/EventChannel$StreamHandler;)V

    .line 5
    .line 6
    .line 7
    return-void
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
