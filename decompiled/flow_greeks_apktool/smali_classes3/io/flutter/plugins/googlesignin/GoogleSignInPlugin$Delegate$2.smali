.class Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lx0/e;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;->clearCredentialState(Lpd/k;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lx0/e;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

.field final synthetic val$callback:Lpd/k;


# direct methods
.method public constructor <init>(Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;Lpd/k;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->this$0:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 2
    .line 3
    iput-object p2, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->val$callback:Lpd/k;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
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
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method


# virtual methods
.method public bridge synthetic onError(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Ly0/a;

    invoke-virtual {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->onError(Ly0/a;)V

    return-void
.end method

.method public onError(Ly0/a;)V
    .locals 4

    .line 2
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->val$callback:Lpd/k;

    new-instance v1, Lio/flutter/plugins/googlesignin/FlutterError;

    .line 3
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    const-string v3, "Clear Failed"

    invoke-direct {v1, v3, p1, v2}, Lio/flutter/plugins/googlesignin/FlutterError;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 4
    invoke-static {v0, v1}, Lio/flutter/plugins/googlesignin/ResultUtilsKt;->completeWithUnitError(Lpd/k;Lio/flutter/plugins/googlesignin/FlutterError;)V

    return-void
.end method

.method public bridge synthetic onResult(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->onResult(Ljava/lang/Void;)V

    return-void
.end method

.method public onResult(Ljava/lang/Void;)V
    .locals 0

    .line 2
    iget-object p1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$2;->val$callback:Lpd/k;

    invoke-static {p1}, Lio/flutter/plugins/googlesignin/ResultUtilsKt;->completeWithUnitSuccess(Lpd/k;)V

    return-void
.end method
