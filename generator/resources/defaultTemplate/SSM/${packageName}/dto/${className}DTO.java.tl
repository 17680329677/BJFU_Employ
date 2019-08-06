@DIRECTIVE SAFE_OUTPUT_OPEN;
package ${data.packageName}.dto;

/**
 * Explain:     ${data.describe!}
 * Date:        ${date(),"yyyy-MM-dd HH:mm:ss"}
 * Coder:       ${data.author!}
 * Version:     1.0
 */
public class ${data.className}DTO {

@for(c in data.columns){
    @if(isNotEmpty(c.simpleColumnComment)){
    /**${c.simpleColumnComment}*/
    @}
    \@Excel(name = "${c.simpleColumnComment}",width=20)
    private ${c.baseJavaType} ${c.property};
@}
@for(c in data.columns){
    public ${c.baseJavaType} get${c.upperProperty}() {
        return this.${c.property};
    }

    public void set${c.upperProperty}(${c.baseJavaType} ${c.property}) {
        this.${c.property} = ${c.property};
    }

@}
    public String toString(){
        StringBuilder strBuf = new StringBuilder("${data.className}DTO{\n");
@for(c in data.columns){
    @if(cLP.last){
        strBuf.append("${c.property}:").append(this.${c.property}).append("\n");
    @} else {
        strBuf.append("${c.property}:").append(this.${c.property}).append(",\n");
    @}
@}
        strBuf.append("}");
        return strBuf.toString();
    }
}
