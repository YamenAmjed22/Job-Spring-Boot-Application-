package com.SpringProjects.firstJopApp.Controller;

import com.SpringProjects.firstJopApp.Models.Review;
import com.SpringProjects.firstJopApp.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviewsForCompany(companyId), HttpStatus.OK);
    }
    @PostMapping("/addReview")
    public ResponseEntity<String> addReviewForCompany(@RequestBody Review review , @PathVariable Long companyId  ){
            boolean wasReviewSaved  = reviewService.addReviewsForCompany(review,companyId);
            if (wasReviewSaved) {
                return new ResponseEntity<>("Review saved successfully ", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Review not saved successfully ", HttpStatus.NOT_FOUND);

            }
    }
    @GetMapping("/review/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId , @PathVariable Long reviewId){
        return  new ResponseEntity<>(reviewService.getReviewByIdForCompany(reviewId,companyId),HttpStatus.OK);
    }
    @PutMapping("/updateReview/{reviewId}")
    public ResponseEntity<String> updateReviewForCompany(@PathVariable Long companyId , @PathVariable Long reviewId , @RequestBody Review review){
        boolean isReviewed = reviewService.updateReviewById(companyId  ,reviewId, review);
        if (isReviewed) {
            return new ResponseEntity<>("Review updated successfully ", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review not updated successfully ", HttpStatus.NOT_FOUND);

        }
    }
    @DeleteMapping("/deleteReview/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId , @PathVariable Long reviewId){
            Boolean isDeleted = reviewService.deleteReview(companyId,reviewId);
            if (isDeleted){
                return new ResponseEntity<>("Review  deleted successfully ", HttpStatus.OK);

            }
                return new ResponseEntity<>("Review not deleted successfully ", HttpStatus.NOT_FOUND);

    }
    }



