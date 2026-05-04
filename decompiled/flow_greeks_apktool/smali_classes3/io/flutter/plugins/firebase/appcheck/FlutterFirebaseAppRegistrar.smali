.class public Lio/flutter/plugins/firebase/appcheck/FlutterFirebaseAppRegistrar;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/firebase/components/ComponentRegistrar;
.implements Lf7/c;


# annotations
.annotation build Landroidx/annotation/Keep;
.end annotation


# static fields
.field private static final DEBUG_SECRET_NAME:Ljava/lang/String; = "fire-app-check-debug-secret"

.field public static debugToken:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
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

.method public static synthetic a(Lio/flutter/plugins/firebase/appcheck/FlutterFirebaseAppRegistrar;Lo7/d;)Lf7/c;
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/flutter/plugins/firebase/appcheck/FlutterFirebaseAppRegistrar;->lambda$getComponents$0(Lo7/d;)Lf7/c;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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

.method private synthetic lambda$getComponents$0(Lo7/d;)Lf7/c;
    .locals 0

    .line 1
    return-object p0
    .line 2
    .line 3
    .line 4
    .line 5
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public getComponents()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lo7/c;",
            ">;"
        }
    .end annotation

    .line 1
    const-string v0, "flutter-fire-app-check"

    .line 2
    .line 3
    const-string v1, "0.4.1-4"

    .line 4
    .line 5
    invoke-static {v0, v1}, Loa/h;->b(Ljava/lang/String;Ljava/lang/String;)Lo7/c;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    const-class v1, Lf7/c;

    .line 10
    .line 11
    invoke-static {v1}, Lo7/c;->c(Ljava/lang/Class;)Lo7/c$b;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    const-string v2, "fire-app-check-debug-secret"

    .line 16
    .line 17
    invoke-virtual {v1, v2}, Lo7/c$b;->h(Ljava/lang/String;)Lo7/c$b;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    new-instance v2, Lio/flutter/plugins/firebase/appcheck/i;

    .line 22
    .line 23
    invoke-direct {v2, p0}, Lio/flutter/plugins/firebase/appcheck/i;-><init>(Lio/flutter/plugins/firebase/appcheck/FlutterFirebaseAppRegistrar;)V

    .line 24
    .line 25
    .line 26
    invoke-virtual {v1, v2}, Lo7/c$b;->f(Lo7/g;)Lo7/c$b;

    .line 27
    .line 28
    .line 29
    move-result-object v1

    .line 30
    invoke-virtual {v1}, Lo7/c$b;->d()Lo7/c;

    .line 31
    .line 32
    .line 33
    move-result-object v1

    .line 34
    filled-new-array {v0, v1}, [Lo7/c;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    return-object v0
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public getDebugSecret()Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lio/flutter/plugins/firebase/appcheck/FlutterFirebaseAppRegistrar;->debugToken:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
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
