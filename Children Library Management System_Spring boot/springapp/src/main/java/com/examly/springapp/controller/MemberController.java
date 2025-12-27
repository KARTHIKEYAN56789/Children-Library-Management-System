package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }
    
    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getMembersByPhone(@PathVariable String phone) {
        List<Member> members = memberService.getMembersByPhone(phone);
        if (members.isEmpty()) {
            return new ResponseEntity<>("No member found with phone: " + phone, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Member>> getMembersByEmail(@PathVariable String email) {
        List<Member> members = memberService.getMembersByEmail(email);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
