.class public final Lvg/b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lvg/a;


# instance fields
.field public final a:Ljava/lang/Object;

.field public final b:Lpd/p;

.field public final c:Lpd/p;

.field public final d:Lpd/p;


# direct methods
.method public constructor <init>(Ljava/lang/Object;Lpd/p;Lpd/p;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lvg/b;->a:Ljava/lang/Object;

    .line 3
    iput-object p2, p0, Lvg/b;->b:Lpd/p;

    .line 4
    iput-object p3, p0, Lvg/b;->c:Lpd/p;

    .line 5
    invoke-static {}, Lvg/f;->a()Lpd/p;

    move-result-object p1

    iput-object p1, p0, Lvg/b;->d:Lpd/p;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Object;Lpd/p;Lpd/p;ILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_0

    const/4 p3, 0x0

    .line 6
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lvg/b;-><init>(Ljava/lang/Object;Lpd/p;Lpd/p;)V

    return-void
.end method
