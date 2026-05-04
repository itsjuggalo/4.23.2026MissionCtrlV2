.class public final Ll1/g0$a;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/k;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ll1/g0;-><init>(Lng/n0;Lpd/k;Lpd/o;Lpd/o;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lpd/k;

.field public final synthetic b:Ll1/g0;

.field public final synthetic c:Lpd/o;


# direct methods
.method public constructor <init>(Lpd/k;Ll1/g0;Lpd/o;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ll1/g0$a;->a:Lpd/k;

    .line 2
    .line 3
    iput-object p2, p0, Ll1/g0$a;->b:Ll1/g0;

    .line 4
    .line 5
    iput-object p3, p0, Ll1/g0$a;->c:Lpd/o;

    .line 6
    .line 7
    const/4 p1, 0x1

    .line 8
    invoke-direct {p0, p1}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 9
    .line 10
    .line 11
    return-void
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
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Ll1/g0$a;->invoke(Ljava/lang/Throwable;)V

    sget-object p1, Lcd/h0;->a:Lcd/h0;

    return-object p1
.end method

.method public final invoke(Ljava/lang/Throwable;)V
    .locals 2

    .line 2
    iget-object v0, p0, Ll1/g0$a;->a:Lpd/k;

    invoke-interface {v0, p1}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 3
    iget-object v0, p0, Ll1/g0$a;->b:Ll1/g0;

    invoke-static {v0}, Ll1/g0;->b(Ll1/g0;)Lpg/g;

    move-result-object v0

    invoke-interface {v0, p1}, Lpg/x;->d(Ljava/lang/Throwable;)Z

    .line 4
    :cond_0
    iget-object v0, p0, Ll1/g0$a;->b:Ll1/g0;

    invoke-static {v0}, Ll1/g0;->b(Ll1/g0;)Lpg/g;

    move-result-object v0

    invoke-interface {v0}, Lpg/w;->b()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lpg/k;->f(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v1, p0, Ll1/g0$a;->c:Lpd/o;

    .line 5
    invoke-interface {v1, v0, p1}, Lpd/o;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 6
    sget-object v0, Lcd/h0;->a:Lcd/h0;

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_0

    return-void
.end method
