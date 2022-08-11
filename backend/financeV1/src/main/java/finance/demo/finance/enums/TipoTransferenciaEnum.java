package finance.demo.finance.enums;

public enum TipoTransferenciaEnum {
    DEBITO(0),
    CREDITO(1);

    public final int tipoConta;
    private TipoTransferenciaEnum(int tipoConta) {
        this.tipoConta = tipoConta;
    }
}
