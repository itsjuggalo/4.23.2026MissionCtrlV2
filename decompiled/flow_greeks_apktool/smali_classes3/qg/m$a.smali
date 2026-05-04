.class public final Lqg/m$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lqg/d;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lqg/m;->a(Lqg/d;Lpd/o;)Lqg/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lqg/d;

.field public final synthetic b:Lpd/o;


# direct methods
.method public constructor <init>(Lqg/d;Lpd/o;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lqg/m$a;->a:Lqg/d;

    .line 2
    .line 3
    iput-object p2, p0, Lqg/m$a;->b:Lpd/o;

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
.method public collect(Lqg/e;Lgd/e;)Ljava/lang/Object;
    .locals 4

    .line 1
    new-instance v0, Lkotlin/jvm/internal/k0;

    .line 2
    .line 3
    invoke-direct {v0}, Lkotlin/jvm/internal/k0;-><init>()V

    .line 4
    .line 5
    .line 6
    iget-object v1, p0, Lqg/m$a;->a:Lqg/d;

    .line 7
    .line 8
    new-instance v2, Lqg/m$b;

    .line 9
    .line 10
    iget-object v3, p0, Lqg/m$a;->b:Lpd/o;

    .line 11
    .line 12
    invoke-direct {v2, v0, p1, v3}, Lqg/m$b;-><init>(Lkotlin/jvm/internal/k0;Lqg/e;Lpd/o;)V

    .line 13
    .line 14
    .line 15
    invoke-interface {v1, v2, p2}, Lqg/d;->collect(Lqg/e;Lgd/e;)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 20
    .line 21
    .line 22
    move-result-object p2

    .line 23
    if-ne p1, p2, :cond_0

    .line 24
    .line 25
    return-object p1

    .line 26
    :cond_0
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 27
    .line 28
    return-object p1
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
