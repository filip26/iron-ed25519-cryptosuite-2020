package com.apicatalog.ld.signature.ed25519;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

import com.apicatalog.ld.node.LdNodeBuilder;
import com.apicatalog.ld.signature.VerificationMethod;
import com.apicatalog.vc.ModelVersion;
import com.apicatalog.vc.integrity.DataIntegrityVocab;
import com.apicatalog.vc.issuer.ProofDraft;

import jakarta.json.JsonObject;

public final class Ed25519Signature2020ProofDraft extends ProofDraft {

    protected final URI purpose;

    protected Instant created;
    protected String domain;
    protected String challenge;
    protected String nonce;

    public Ed25519Signature2020ProofDraft(
            VerificationMethod method,
            URI purpose) {
        super(Ed25519Signature2020Proof.CRYPTO, method);
        this.purpose = purpose;
    }

    public Ed25519Signature2020ProofDraft(
            URI method,
            URI purpose) {
        super(Ed25519Signature2020Proof.CRYPTO, method);
        this.purpose = purpose;
    }

    public void created(Instant created) {
        this.created = created;
    }

    public void challenge(String challenge) {
        this.challenge = challenge;
    }

    public void domain(String domain) {
        this.domain = domain;
    }

    public void nonce(String nonce) {
        this.nonce = nonce;
    }

    @Override
    public JsonObject unsigned() {
        return unsigned(new LdNodeBuilder()).build();
    }
    
    /**
     * Returns an expanded signed proof. i.e. the given proof with proof value attached.
     * 
     * @param unsignedProof
     * @param proofValue
     * @return
     */
    public static final JsonObject signed(JsonObject unsignedProof, JsonObject proofValue) {
        return LdNodeBuilder.of(unsignedProof).set(DataIntegrityVocab.PROOF_VALUE).value(proofValue).build();
    }
    
    protected LdNodeBuilder unsigned(LdNodeBuilder builder) {
        super.unsigned(builder, Ed25519Signature2020.METHOD_ADAPTER);
        
        builder.type(Ed25519Signature2020.ID);
        builder.set(DataIntegrityVocab.PURPOSE).id(purpose);
        builder.set(DataIntegrityVocab.CREATED).xsdDateTime(created != null ? created : Instant.now());

        if (domain != null) {
            builder.set(DataIntegrityVocab.DOMAIN).string(domain);
        }
        if (challenge != null) {
            builder.set(DataIntegrityVocab.CHALLENGE).string(challenge);
        }
        if (nonce != null) {
            builder.set(DataIntegrityVocab.NONCE).string(nonce);
        }

        return builder;
    }
    
    @Override
    public Collection<String> context(ModelVersion model) {
        return Arrays.asList(Ed25519Signature2020.CONTEXT);
    }
}