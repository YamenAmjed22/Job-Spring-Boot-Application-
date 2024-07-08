package com.SpringProjects.firstJopApp.Service;

import com.SpringProjects.firstJopApp.Models.Company;
import com.SpringProjects.firstJopApp.Models.Review;
import com.SpringProjects.firstJopApp.Repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private final ReviewRepo reviewRepo;
    private final CompanyService companyService;

    public ReviewService(ReviewRepo reviewRepo,CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }


    public List<Review> getAllReviewsForCompany(Long companyId){
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews ;
    }
    // select * from review where companyId = ?
    public Boolean addReviewsForCompany(Review review , Long companyId){
        Company company = companyService.getCompanyById(companyId);
        if (company!=null) {
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        else
            {
                return false ;
            }

    }
    public Review getReviewByIdForCompany(Long companyId , Long reviewId ){
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);

    }
    public Boolean updateReviewById(Long companyId , Long reviewId,Review updatedReview){
        Company company = companyService.getCompanyById(companyId);
        if (company!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepo.save(updatedReview);
            return true ;
        }
        return false ;

    }
    public Boolean deleteReview(Long companyId , Long reviewId){
        Company company = companyService.getCompanyById(companyId);
        if (company!=null && reviewRepo.existsById(reviewId)){
            Review review = reviewRepo.findById(reviewId).orElse(null);
            Company company1 = review.getCompany();
            company1.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId , company1);
            reviewRepo.deleteById(reviewId);
            return  true ;

        }
        return false;

    }



}
