.class public final Lvg/d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lvg/c;


# instance fields
.field public final a:Ljava/lang/Object;

.field public final b:Lpd/p;

.field public final c:Lpd/p;

.field public final d:Lpd/p;


# direct methods
.method public constructor <init>(Ljava/lang/Object;Lpd/p;Lpd/p;Lpd/p;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lvg/d;->a:Ljava/lang/Object;

    .line 3
    iput-object p2, p0, Lvg/d;->b:Lpd/p;

    .line 4
    iput-object p3, p0, Lvg/d;->c:Lpd/p;

    .line 5
    iput-object p4, p0, Lvg/d;->d:Lpd/p;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Object;Lpd/p;Lpd/p;Lpd/p;ILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p5, p5, 0x8

    if-eqz p5, :cond_0

    const/4 p4, 0x0

    .line 6
    :cond_0
    invoke-direct {p0, p1, p2, p3, p4}, Lvg/d;-><init>(Ljava/lang/Object;Lpd/p;Lpd/p;Lpd/p;)V

    return-void
.end method
