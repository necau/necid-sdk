/**
 * null
 */
package au.com.nec.id.client.model;

import java.io.Serializable;
import javax.annotation.Generated;
import com.amazonaws.protocol.StructuredPojo;
import com.amazonaws.protocol.ProtocolMarshaller;

/**
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/api-1.1/Attributes" target="_top">AWS API Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class Attributes implements Serializable, Cloneable, StructuredPojo {

    private FaceArea faceArea;

    private String facePan;

    private String faceQualityScore;

    private String faceRoll;

    private String faceScore;

    private String faceTilt;

    private String frontalFaceScore;

    private HeadArea headArea;

    private LeftEyeCenter leftEyeCenter;

    private RightEyeCenter rightEyeCenter;

    /**
     * @param faceArea
     */

    public void setFaceArea(FaceArea faceArea) {
        this.faceArea = faceArea;
    }

    /**
     * @return
     */

    public FaceArea getFaceArea() {
        return this.faceArea;
    }

    /**
     * @param faceArea
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes faceArea(FaceArea faceArea) {
        setFaceArea(faceArea);
        return this;
    }

    /**
     * @param facePan
     */

    public void setFacePan(String facePan) {
        this.facePan = facePan;
    }

    /**
     * @return
     */

    public String getFacePan() {
        return this.facePan;
    }

    /**
     * @param facePan
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes facePan(String facePan) {
        setFacePan(facePan);
        return this;
    }

    /**
     * @param faceQualityScore
     */

    public void setFaceQualityScore(String faceQualityScore) {
        this.faceQualityScore = faceQualityScore;
    }

    /**
     * @return
     */

    public String getFaceQualityScore() {
        return this.faceQualityScore;
    }

    /**
     * @param faceQualityScore
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes faceQualityScore(String faceQualityScore) {
        setFaceQualityScore(faceQualityScore);
        return this;
    }

    /**
     * @param faceRoll
     */

    public void setFaceRoll(String faceRoll) {
        this.faceRoll = faceRoll;
    }

    /**
     * @return
     */

    public String getFaceRoll() {
        return this.faceRoll;
    }

    /**
     * @param faceRoll
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes faceRoll(String faceRoll) {
        setFaceRoll(faceRoll);
        return this;
    }

    /**
     * @param faceScore
     */

    public void setFaceScore(String faceScore) {
        this.faceScore = faceScore;
    }

    /**
     * @return
     */

    public String getFaceScore() {
        return this.faceScore;
    }

    /**
     * @param faceScore
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes faceScore(String faceScore) {
        setFaceScore(faceScore);
        return this;
    }

    /**
     * @param faceTilt
     */

    public void setFaceTilt(String faceTilt) {
        this.faceTilt = faceTilt;
    }

    /**
     * @return
     */

    public String getFaceTilt() {
        return this.faceTilt;
    }

    /**
     * @param faceTilt
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes faceTilt(String faceTilt) {
        setFaceTilt(faceTilt);
        return this;
    }

    /**
     * @param frontalFaceScore
     */

    public void setFrontalFaceScore(String frontalFaceScore) {
        this.frontalFaceScore = frontalFaceScore;
    }

    /**
     * @return
     */

    public String getFrontalFaceScore() {
        return this.frontalFaceScore;
    }

    /**
     * @param frontalFaceScore
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes frontalFaceScore(String frontalFaceScore) {
        setFrontalFaceScore(frontalFaceScore);
        return this;
    }

    /**
     * @param headArea
     */

    public void setHeadArea(HeadArea headArea) {
        this.headArea = headArea;
    }

    /**
     * @return
     */

    public HeadArea getHeadArea() {
        return this.headArea;
    }

    /**
     * @param headArea
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes headArea(HeadArea headArea) {
        setHeadArea(headArea);
        return this;
    }

    /**
     * @param leftEyeCenter
     */

    public void setLeftEyeCenter(LeftEyeCenter leftEyeCenter) {
        this.leftEyeCenter = leftEyeCenter;
    }

    /**
     * @return
     */

    public LeftEyeCenter getLeftEyeCenter() {
        return this.leftEyeCenter;
    }

    /**
     * @param leftEyeCenter
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes leftEyeCenter(LeftEyeCenter leftEyeCenter) {
        setLeftEyeCenter(leftEyeCenter);
        return this;
    }

    /**
     * @param rightEyeCenter
     */

    public void setRightEyeCenter(RightEyeCenter rightEyeCenter) {
        this.rightEyeCenter = rightEyeCenter;
    }

    /**
     * @return
     */

    public RightEyeCenter getRightEyeCenter() {
        return this.rightEyeCenter;
    }

    /**
     * @param rightEyeCenter
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Attributes rightEyeCenter(RightEyeCenter rightEyeCenter) {
        setRightEyeCenter(rightEyeCenter);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFaceArea() != null)
            sb.append("FaceArea: ").append(getFaceArea()).append(",");
        if (getFacePan() != null)
            sb.append("FacePan: ").append(getFacePan()).append(",");
        if (getFaceQualityScore() != null)
            sb.append("FaceQualityScore: ").append(getFaceQualityScore()).append(",");
        if (getFaceRoll() != null)
            sb.append("FaceRoll: ").append(getFaceRoll()).append(",");
        if (getFaceScore() != null)
            sb.append("FaceScore: ").append(getFaceScore()).append(",");
        if (getFaceTilt() != null)
            sb.append("FaceTilt: ").append(getFaceTilt()).append(",");
        if (getFrontalFaceScore() != null)
            sb.append("FrontalFaceScore: ").append(getFrontalFaceScore()).append(",");
        if (getHeadArea() != null)
            sb.append("HeadArea: ").append(getHeadArea()).append(",");
        if (getLeftEyeCenter() != null)
            sb.append("LeftEyeCenter: ").append(getLeftEyeCenter()).append(",");
        if (getRightEyeCenter() != null)
            sb.append("RightEyeCenter: ").append(getRightEyeCenter());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Attributes == false)
            return false;
        Attributes other = (Attributes) obj;
        if (other.getFaceArea() == null ^ this.getFaceArea() == null)
            return false;
        if (other.getFaceArea() != null && other.getFaceArea().equals(this.getFaceArea()) == false)
            return false;
        if (other.getFacePan() == null ^ this.getFacePan() == null)
            return false;
        if (other.getFacePan() != null && other.getFacePan().equals(this.getFacePan()) == false)
            return false;
        if (other.getFaceQualityScore() == null ^ this.getFaceQualityScore() == null)
            return false;
        if (other.getFaceQualityScore() != null && other.getFaceQualityScore().equals(this.getFaceQualityScore()) == false)
            return false;
        if (other.getFaceRoll() == null ^ this.getFaceRoll() == null)
            return false;
        if (other.getFaceRoll() != null && other.getFaceRoll().equals(this.getFaceRoll()) == false)
            return false;
        if (other.getFaceScore() == null ^ this.getFaceScore() == null)
            return false;
        if (other.getFaceScore() != null && other.getFaceScore().equals(this.getFaceScore()) == false)
            return false;
        if (other.getFaceTilt() == null ^ this.getFaceTilt() == null)
            return false;
        if (other.getFaceTilt() != null && other.getFaceTilt().equals(this.getFaceTilt()) == false)
            return false;
        if (other.getFrontalFaceScore() == null ^ this.getFrontalFaceScore() == null)
            return false;
        if (other.getFrontalFaceScore() != null && other.getFrontalFaceScore().equals(this.getFrontalFaceScore()) == false)
            return false;
        if (other.getHeadArea() == null ^ this.getHeadArea() == null)
            return false;
        if (other.getHeadArea() != null && other.getHeadArea().equals(this.getHeadArea()) == false)
            return false;
        if (other.getLeftEyeCenter() == null ^ this.getLeftEyeCenter() == null)
            return false;
        if (other.getLeftEyeCenter() != null && other.getLeftEyeCenter().equals(this.getLeftEyeCenter()) == false)
            return false;
        if (other.getRightEyeCenter() == null ^ this.getRightEyeCenter() == null)
            return false;
        if (other.getRightEyeCenter() != null && other.getRightEyeCenter().equals(this.getRightEyeCenter()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getFaceArea() == null) ? 0 : getFaceArea().hashCode());
        hashCode = prime * hashCode + ((getFacePan() == null) ? 0 : getFacePan().hashCode());
        hashCode = prime * hashCode + ((getFaceQualityScore() == null) ? 0 : getFaceQualityScore().hashCode());
        hashCode = prime * hashCode + ((getFaceRoll() == null) ? 0 : getFaceRoll().hashCode());
        hashCode = prime * hashCode + ((getFaceScore() == null) ? 0 : getFaceScore().hashCode());
        hashCode = prime * hashCode + ((getFaceTilt() == null) ? 0 : getFaceTilt().hashCode());
        hashCode = prime * hashCode + ((getFrontalFaceScore() == null) ? 0 : getFrontalFaceScore().hashCode());
        hashCode = prime * hashCode + ((getHeadArea() == null) ? 0 : getHeadArea().hashCode());
        hashCode = prime * hashCode + ((getLeftEyeCenter() == null) ? 0 : getLeftEyeCenter().hashCode());
        hashCode = prime * hashCode + ((getRightEyeCenter() == null) ? 0 : getRightEyeCenter().hashCode());
        return hashCode;
    }

    @Override
    public Attributes clone() {
        try {
            return (Attributes) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

    @com.amazonaws.annotation.SdkInternalApi
    @Override
    public void marshall(ProtocolMarshaller protocolMarshaller) {
        au.com.nec.id.client.model.transform.AttributesMarshaller.getInstance().marshall(this, protocolMarshaller);
    }
}
