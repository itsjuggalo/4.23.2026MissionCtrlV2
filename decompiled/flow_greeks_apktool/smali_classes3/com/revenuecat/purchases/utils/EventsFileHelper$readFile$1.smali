.class final Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/k;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/revenuecat/purchases/utils/EventsFileHelper;->readFile(Lpd/k;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/v;",
        "Lpd/k;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0008\u001a\u00020\u0005\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00002\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\n\u00a2\u0006\u0004\u0008\u0006\u0010\u0007"
    }
    d2 = {
        "Lcom/revenuecat/purchases/utils/Event;",
        "T",
        "Ljg/h;",
        "",
        "sequence",
        "Lcd/h0;",
        "invoke",
        "(Ljg/h;)V",
        "<anonymous>"
    }
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
.end annotation


# instance fields
.field final synthetic $block:Lpd/k;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lpd/k;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/revenuecat/purchases/utils/EventsFileHelper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/revenuecat/purchases/utils/EventsFileHelper<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lpd/k;Lcom/revenuecat/purchases/utils/EventsFileHelper;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lpd/k;",
            "Lcom/revenuecat/purchases/utils/EventsFileHelper<",
            "TT;>;)V"
        }
    .end annotation

    .line 1
    iput-object p1, p0, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;->$block:Lpd/k;

    .line 2
    .line 3
    iput-object p2, p0, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;->this$0:Lcom/revenuecat/purchases/utils/EventsFileHelper;

    .line 4
    .line 5
    const/4 p1, 0x1

    .line 6
    invoke-direct {p0, p1}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 7
    .line 8
    .line 9
    return-void
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
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Ljg/h;

    invoke-virtual {p0, p1}, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;->invoke(Ljg/h;)V

    sget-object p1, Lcd/h0;->a:Lcd/h0;

    return-object p1
.end method

.method public final invoke(Ljg/h;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljg/h;",
            ")V"
        }
    .end annotation

    const-string v0, "sequence"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 2
    iget-object v0, p0, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;->$block:Lpd/k;

    new-instance v1, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1$1;

    iget-object v2, p0, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1;->this$0:Lcom/revenuecat/purchases/utils/EventsFileHelper;

    invoke-direct {v1, v2}, Lcom/revenuecat/purchases/utils/EventsFileHelper$readFile$1$1;-><init>(Lcom/revenuecat/purchases/utils/EventsFileHelper;)V

    invoke-static {p1, v1}, Ljg/t;->E(Ljg/h;Lpd/k;)Ljg/h;

    move-result-object p1

    invoke-interface {v0, p1}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
