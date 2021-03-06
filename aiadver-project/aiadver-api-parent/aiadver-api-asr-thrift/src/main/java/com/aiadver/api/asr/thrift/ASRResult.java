/**
 * Autogenerated by Thrift Compiler (0.13.0)
 * <p>
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package com.aiadver.api.asr.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-10-10")
public class ASRResult implements org.apache.thrift.TBase<ASRResult, ASRResult._Fields>, java.io.Serializable, Cloneable, Comparable<ASRResult> {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ASRResult");
    private static final org.apache.thrift.protocol.TField RSLT_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("rsltStatus", org.apache.thrift.protocol.TType.I32, (short) 1);
    private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorCode", org.apache.thrift.protocol.TType.I32, (short) 2);
    private static final org.apache.thrift.protocol.TField TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("text", org.apache.thrift.protocol.TType.STRING, (short) 3);
    private static final org.apache.thrift.protocol.TField IS_INTERRUPTED_FIELD_DESC = new org.apache.thrift.protocol.TField("isInterrupted", org.apache.thrift.protocol.TType.I32, (short) 4);
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ASRResultStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ASRResultTupleSchemeFactory();
    // isset id assignments
    private static final int __RSLTSTATUS_ISSET_ID = 0;
    private static final int __ERRORCODE_ISSET_ID = 1;
    private static final int __ISINTERRUPTED_ISSET_ID = 2;

    static {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        tmpMap.put(_Fields.RSLT_STATUS, new org.apache.thrift.meta_data.FieldMetaData("rsltStatus", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errorCode", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.TEXT, new org.apache.thrift.meta_data.FieldMetaData("text", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        tmpMap.put(_Fields.IS_INTERRUPTED, new org.apache.thrift.meta_data.FieldMetaData("isInterrupted", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ASRResult.class, metaDataMap);
    }

    public int rsltStatus; // required
    public int errorCode; // required
    public @org.apache.thrift.annotation.Nullable
    java.lang.String text; // required
    public int isInterrupted; // required
    private byte __isset_bitfield = 0;

    public ASRResult() {
    }

    public ASRResult(
            int rsltStatus,
            int errorCode,
            java.lang.String text,
            int isInterrupted) {
        this();
        this.rsltStatus = rsltStatus;
        setRsltStatusIsSet(true);
        this.errorCode = errorCode;
        setErrorCodeIsSet(true);
        this.text = text;
        this.isInterrupted = isInterrupted;
        setIsInterruptedIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public ASRResult(ASRResult other) {
        __isset_bitfield = other.__isset_bitfield;
        this.rsltStatus = other.rsltStatus;
        this.errorCode = other.errorCode;
        if (other.isSetText()) {
            this.text = other.text;
        }
        this.isInterrupted = other.isInterrupted;
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }

    public ASRResult deepCopy() {
        return new ASRResult(this);
    }

    @Override
    public void clear() {
        setRsltStatusIsSet(false);
        this.rsltStatus = 0;
        setErrorCodeIsSet(false);
        this.errorCode = 0;
        this.text = null;
        setIsInterruptedIsSet(false);
        this.isInterrupted = 0;
    }

    public int getRsltStatus() {
        return this.rsltStatus;
    }

    public ASRResult setRsltStatus(int rsltStatus) {
        this.rsltStatus = rsltStatus;
        setRsltStatusIsSet(true);
        return this;
    }

    public void unsetRsltStatus() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RSLTSTATUS_ISSET_ID);
    }

    /**
     * Returns true if field rsltStatus is set (has been assigned a value) and false otherwise
     */
    public boolean isSetRsltStatus() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RSLTSTATUS_ISSET_ID);
    }

    public void setRsltStatusIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RSLTSTATUS_ISSET_ID, value);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public ASRResult setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        setErrorCodeIsSet(true);
        return this;
    }

    public void unsetErrorCode() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ERRORCODE_ISSET_ID);
    }

    /**
     * Returns true if field errorCode is set (has been assigned a value) and false otherwise
     */
    public boolean isSetErrorCode() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ERRORCODE_ISSET_ID);
    }

    public void setErrorCodeIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ERRORCODE_ISSET_ID, value);
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.String getText() {
        return this.text;
    }

    public ASRResult setText(@org.apache.thrift.annotation.Nullable java.lang.String text) {
        this.text = text;
        return this;
    }

    public void unsetText() {
        this.text = null;
    }

    /**
     * Returns true if field text is set (has been assigned a value) and false otherwise
     */
    public boolean isSetText() {
        return this.text != null;
    }

    public void setTextIsSet(boolean value) {
        if (!value) {
            this.text = null;
        }
    }

    public int getIsInterrupted() {
        return this.isInterrupted;
    }

    public ASRResult setIsInterrupted(int isInterrupted) {
        this.isInterrupted = isInterrupted;
        setIsInterruptedIsSet(true);
        return this;
    }

    public void unsetIsInterrupted() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ISINTERRUPTED_ISSET_ID);
    }

    /**
     * Returns true if field isInterrupted is set (has been assigned a value) and false otherwise
     */
    public boolean isSetIsInterrupted() {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ISINTERRUPTED_ISSET_ID);
    }

    public void setIsInterruptedIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ISINTERRUPTED_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        switch (field) {
            case RSLT_STATUS:
                if (value == null) {
                    unsetRsltStatus();
                } else {
                    setRsltStatus((java.lang.Integer) value);
                }
                break;

            case ERROR_CODE:
                if (value == null) {
                    unsetErrorCode();
                } else {
                    setErrorCode((java.lang.Integer) value);
                }
                break;

            case TEXT:
                if (value == null) {
                    unsetText();
                } else {
                    setText((java.lang.String) value);
                }
                break;

            case IS_INTERRUPTED:
                if (value == null) {
                    unsetIsInterrupted();
                } else {
                    setIsInterrupted((java.lang.Integer) value);
                }
                break;

        }
    }

    @org.apache.thrift.annotation.Nullable
    public java.lang.Object getFieldValue(_Fields field) {
        switch (field) {
            case RSLT_STATUS:
                return getRsltStatus();

            case ERROR_CODE:
                return getErrorCode();

            case TEXT:
                return getText();

            case IS_INTERRUPTED:
                return getIsInterrupted();

        }
        throw new java.lang.IllegalStateException();
    }

    /**
     * Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
     */
    public boolean isSet(_Fields field) {
        if (field == null) {
            throw new java.lang.IllegalArgumentException();
        }

        switch (field) {
            case RSLT_STATUS:
                return isSetRsltStatus();
            case ERROR_CODE:
                return isSetErrorCode();
            case TEXT:
                return isSetText();
            case IS_INTERRUPTED:
                return isSetIsInterrupted();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
        if (that == null)
            return false;
        if (that instanceof ASRResult)
            return this.equals((ASRResult) that);
        return false;
    }

    public boolean equals(ASRResult that) {
        if (that == null)
            return false;
        if (this == that)
            return true;

        boolean this_present_rsltStatus = true;
        boolean that_present_rsltStatus = true;
        if (this_present_rsltStatus || that_present_rsltStatus) {
            if (!(this_present_rsltStatus && that_present_rsltStatus))
                return false;
            if (this.rsltStatus != that.rsltStatus)
                return false;
        }

        boolean this_present_errorCode = true;
        boolean that_present_errorCode = true;
        if (this_present_errorCode || that_present_errorCode) {
            if (!(this_present_errorCode && that_present_errorCode))
                return false;
            if (this.errorCode != that.errorCode)
                return false;
        }

        boolean this_present_text = true && this.isSetText();
        boolean that_present_text = true && that.isSetText();
        if (this_present_text || that_present_text) {
            if (!(this_present_text && that_present_text))
                return false;
            if (!this.text.equals(that.text))
                return false;
        }

        boolean this_present_isInterrupted = true;
        boolean that_present_isInterrupted = true;
        if (this_present_isInterrupted || that_present_isInterrupted) {
            if (!(this_present_isInterrupted && that_present_isInterrupted))
                return false;
            if (this.isInterrupted != that.isInterrupted)
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 8191 + rsltStatus;

        hashCode = hashCode * 8191 + errorCode;

        hashCode = hashCode * 8191 + ((isSetText()) ? 131071 : 524287);
        if (isSetText())
            hashCode = hashCode * 8191 + text.hashCode();

        hashCode = hashCode * 8191 + isInterrupted;

        return hashCode;
    }

    @Override
    public int compareTo(ASRResult other) {
        if (!getClass().equals(other.getClass())) {
            return getClass().getName().compareTo(other.getClass().getName());
        }

        int lastComparison = 0;

        lastComparison = java.lang.Boolean.valueOf(isSetRsltStatus()).compareTo(other.isSetRsltStatus());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetRsltStatus()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rsltStatus, other.rsltStatus);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetErrorCode()).compareTo(other.isSetErrorCode());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetErrorCode()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorCode, other.errorCode);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetText()).compareTo(other.isSetText());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetText()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.text, other.text);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        lastComparison = java.lang.Boolean.valueOf(isSetIsInterrupted()).compareTo(other.isSetIsInterrupted());
        if (lastComparison != 0) {
            return lastComparison;
        }
        if (isSetIsInterrupted()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isInterrupted, other.isInterrupted);
            if (lastComparison != 0) {
                return lastComparison;
            }
        }
        return 0;
    }

    @org.apache.thrift.annotation.Nullable
    public _Fields fieldForId(int fieldId) {
        return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        scheme(oprot).write(oprot, this);
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ASRResult(");
        boolean first = true;

        sb.append("rsltStatus:");
        sb.append(this.rsltStatus);
        first = false;
        if (!first) sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.errorCode);
        first = false;
        if (!first) sb.append(", ");
        sb.append("text:");
        if (this.text == null) {
            sb.append("null");
        } else {
            sb.append(this.text);
        }
        first = false;
        if (!first) sb.append(", ");
        sb.append("isInterrupted:");
        sb.append(this.isInterrupted);
        first = false;
        sb.append(")");
        return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
        // check for required fields
        // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
            __isset_bitfield = 0;
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } catch (org.apache.thrift.TException te) {
            throw new java.io.IOException(te);
        }
    }

    /**
     * The set of fields this struct contains, along with convenience methods for finding and manipulating them.
     */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        RSLT_STATUS((short) 1, "rsltStatus"),
        ERROR_CODE((short) 2, "errorCode"),
        TEXT((short) 3, "text"),
        IS_INTERRUPTED((short) 4, "isInterrupted");

        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

        static {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                byName.put(field.getFieldName(), field);
            }
        }

        private final short _thriftId;
        private final java.lang.String _fieldName;

        _Fields(short thriftId, java.lang.String fieldName) {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByThriftId(int fieldId) {
            switch (fieldId) {
                case 1: // RSLT_STATUS
                    return RSLT_STATUS;
                case 2: // ERROR_CODE
                    return ERROR_CODE;
                case 3: // TEXT
                    return TEXT;
                case 4: // IS_INTERRUPTED
                    return IS_INTERRUPTED;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception
         * if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        @org.apache.thrift.annotation.Nullable
        public static _Fields findByName(java.lang.String name) {
            return byName.get(name);
        }

        public short getThriftFieldId() {
            return _thriftId;
        }

        public java.lang.String getFieldName() {
            return _fieldName;
        }
    }

    private static class ASRResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public ASRResultStandardScheme getScheme() {
            return new ASRResultStandardScheme();
        }
    }

    private static class ASRResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<ASRResult> {

        public void read(org.apache.thrift.protocol.TProtocol iprot, ASRResult struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TField schemeField;
            iprot.readStructBegin();
            while (true) {
                schemeField = iprot.readFieldBegin();
                if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                    break;
                }
                switch (schemeField.id) {
                    case 1: // RSLT_STATUS
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.rsltStatus = iprot.readI32();
                            struct.setRsltStatusIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 2: // ERROR_CODE
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.errorCode = iprot.readI32();
                            struct.setErrorCodeIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 3: // TEXT
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.text = iprot.readString();
                            struct.setTextIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    case 4: // IS_INTERRUPTED
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.isInterrupted = iprot.readI32();
                            struct.setIsInterruptedIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                iprot.readFieldEnd();
            }
            iprot.readStructEnd();

            // check for required fields of primitive type, which can't be checked in the validate method
            struct.validate();
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot, ASRResult struct) throws org.apache.thrift.TException {
            struct.validate();

            oprot.writeStructBegin(STRUCT_DESC);
            oprot.writeFieldBegin(RSLT_STATUS_FIELD_DESC);
            oprot.writeI32(struct.rsltStatus);
            oprot.writeFieldEnd();
            oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
            oprot.writeI32(struct.errorCode);
            oprot.writeFieldEnd();
            if (struct.text != null) {
                oprot.writeFieldBegin(TEXT_FIELD_DESC);
                oprot.writeString(struct.text);
                oprot.writeFieldEnd();
            }
            oprot.writeFieldBegin(IS_INTERRUPTED_FIELD_DESC);
            oprot.writeI32(struct.isInterrupted);
            oprot.writeFieldEnd();
            oprot.writeFieldStop();
            oprot.writeStructEnd();
        }

    }

    private static class ASRResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        public ASRResultTupleScheme getScheme() {
            return new ASRResultTupleScheme();
        }
    }

    private static class ASRResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<ASRResult> {

        @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, ASRResult struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet optionals = new java.util.BitSet();
            if (struct.isSetRsltStatus()) {
                optionals.set(0);
            }
            if (struct.isSetErrorCode()) {
                optionals.set(1);
            }
            if (struct.isSetText()) {
                optionals.set(2);
            }
            if (struct.isSetIsInterrupted()) {
                optionals.set(3);
            }
            oprot.writeBitSet(optionals, 4);
            if (struct.isSetRsltStatus()) {
                oprot.writeI32(struct.rsltStatus);
            }
            if (struct.isSetErrorCode()) {
                oprot.writeI32(struct.errorCode);
            }
            if (struct.isSetText()) {
                oprot.writeString(struct.text);
            }
            if (struct.isSetIsInterrupted()) {
                oprot.writeI32(struct.isInterrupted);
            }
        }

        @Override
        public void read(org.apache.thrift.protocol.TProtocol prot, ASRResult struct) throws org.apache.thrift.TException {
            org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            java.util.BitSet incoming = iprot.readBitSet(4);
            if (incoming.get(0)) {
                struct.rsltStatus = iprot.readI32();
                struct.setRsltStatusIsSet(true);
            }
            if (incoming.get(1)) {
                struct.errorCode = iprot.readI32();
                struct.setErrorCodeIsSet(true);
            }
            if (incoming.get(2)) {
                struct.text = iprot.readString();
                struct.setTextIsSet(true);
            }
            if (incoming.get(3)) {
                struct.isInterrupted = iprot.readI32();
                struct.setIsInterruptedIsSet(true);
            }
        }
    }
}

